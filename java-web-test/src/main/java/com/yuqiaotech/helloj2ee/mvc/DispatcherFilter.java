package com.yuqiaotech.helloj2ee.mvc;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 本过滤器是作为mvc的前端控制器。 用来根据请求路径和配置文件的内容，触发相应的处理类(我们称为handler)的handler方法，
 * 然后获取该方法返回的对象，调用其display方法进行显示。
 *
 */
public class DispatcherFilter implements Filter {
	private String contextPath;
	public String configFile = "/mvc.xml";
	public static final String DEFAULTHANDLERMETHOD = "handle";
	public Map<String, HandlerConfig> handlerMapping = new HashMap<String, HandlerConfig>();

	/**
	 * 初始化。 读取配置文件的位置，分析配置文件的内容。 并将配置内容转化为HandlerConfig对象，
	 * 然后以contextPath+path为key，放到一个map里，方便后续使用。
	 */
	public void init(FilterConfig cfg) throws ServletException {
		System.out.println("DispatcherFilter init.");
		String configFile = cfg.getInitParameter("configFile");
		if (configFile != null)
			this.configFile = configFile;
		contextPath = cfg.getServletContext().getContextPath();
		parseConfigFile();

	}

	private void parseConfigFile() {
		InputStream in = DispatcherFilter.class.getResourceAsStream(configFile);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(in);
			NodeList nodes = doc.getElementsByTagName("handler");
			for (int i = 0; i < nodes.getLength(); i++) {
				Element ele = (Element) nodes.item(i);
				// 现在很简单只有几个属性
				String path = ele.getAttribute("path");
				String clazz = ele.getAttribute("class");
				String method = ele.getAttribute("method");
				HandlerConfig handlerConfig = new HandlerConfig();
				handlerConfig.setClazz(clazz);
				handlerConfig.setPath(path);
				handlerConfig.setMethod(method);

				NodeList views = ele.getElementsByTagName("view");// 注意与ele.getChildNodes()的区别
				if (views != null) {
					for (int j = 0; j < views.getLength(); j++) {
						Element viewEle = (Element) views.item(j);
						ViewConfig viewConfig = new ViewConfig();
						viewConfig.setName(viewEle.getAttribute("name"));
						viewConfig.setType(viewEle.getAttribute("type"));
						viewConfig.setValue(viewEle.getFirstChild().getNodeValue());// 注意这里
						handlerConfig.putView(viewConfig.getName(), viewConfig);
					}
				}

				handlerMapping.put(contextPath + path, handlerConfig);
			}
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		} catch (SAXException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void destroy() {
		System.out.println("DispatcherFilter: bye.");
	}

	/**
	 * 拦截请求。
	 *
	 * 从handlerMapping查找是否有对应当前请求路径的handler， 如果没有的话，继续chain.doFilter(request,
	 * response); 如果有的话，就实例化handler类，然后调用其handler方法，
	 * 然后处理返回的对象，如果返回的是String，那么包装成一个ForwardView对象， 否则调用返回对象的display方法。
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		// 包装一下request，当调用getAttribuute的时候是执行的包装类的getAttribute。
		request = new SimpleRequestWrapper(request);

		String url = request.getRequestURI();
		HandlerConfig handlerConfig = handlerMapping.get(url);

		if (handlerConfig != null) {
			MvcServletContext context = new MvcServletContext();
			context.setRequest(request);
			context.setResponse(response);
			context.setSession(request.getSession(true));
			MvcContext.context.set(context);

			Object handler = newInstance(handlerConfig);
			context.setHandler(handler);

			// 自动填充参数
			autowireParameters(request, handler);

			// 获取需要执行的方法名
			String methodNameInvoke = DEFAULTHANDLERMETHOD;
			String methodNameCfg = handlerConfig.getMethod();
			if (methodNameCfg != null && !"".equals(methodNameCfg)) {
				methodNameInvoke = handlerConfig.getMethod();
			} else {
				Enumeration<String> enuma = request.getParameterNames();
				while (enuma.hasMoreElements()) {
					String pName = enuma.nextElement();
					if (pName.startsWith("method:")) {
						methodNameInvoke = pName.substring("method:".length());
						break;
					}
				}
			} // struts2还支持actionName!methodName的方式。

			// 执行方法并得到view对象
			Object view = invokeHandler(handlerConfig, handler, methodNameInvoke);

			// 分析view的情况。
			if (view != null) {
				// 获取如果返回的是字符串，
				// 那么就使用该字符串从配置中找到相应的view
				if (view instanceof String) {
					ViewConfig v = handlerConfig.getView((String) view);
					if (v == null)
						throw new RuntimeException("no such view with name [" + view + "]");
					// 这里显然太不灵活，不具备可扩展性。
					String type = v.getType();
					String viewValue = v.getValue();
					if ("redirect".equals(type)) {
						view = new RedirectView(viewValue);
					} else {
						view = new ForwardView(viewValue);
					}
				}
				invokeDisplay(handlerConfig, view);
			}
			// 如果view为null，说明handler已经处理了显示问题
		} else {
			chain.doFilter(request, response);
		}
	}

	// TODO 这个和struts2相比当然实在是太简陋了。
	private void autowireParameters(HttpServletRequest request, Object handler) {
		Enumeration<String> enuma = request.getParameterNames();
		while (enuma.hasMoreElements()) {
			String pName = enuma.nextElement();
			if (pName.contains(":"))
				continue;
			String[] segments = pName.split("[.]");
			if (segments.length == 1) {
				try {
					Method m = handler.getClass().getMethod("set" + capital(pName), String.class);
					String v = request.getParameter(pName);
					m.invoke(handler, new Object[] { v });
				} catch (Exception e) {
					// TODO
				}

			} else {
				// TODO
			}
		}
	}

	private final String capital(String s) {
		StringBuffer sb = new StringBuffer(s.length());
		sb.append(Character.toUpperCase(s.charAt(0)));
		sb.append(s.substring(1));
		return sb.toString();
	}

	/**
	 * 实例化Handler类。
	 * 
	 * @param handlerConfig
	 * @return
	 */
	private Object newInstance(HandlerConfig handlerConfig) {
		try {
			return Class.forName(handlerConfig.getClazz()).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 触发Handler类的handler方法。 本mvc框架处于演示反射的目的，以及为struts2做准备的目的，
	 * 没有规定handler类必须实现特定接口，而只是规定需要有个方法名叫handler。
	 * 
	 * @param handlerConfig
	 * @param o
	 * @return
	 */
	private Object invokeHandler(HandlerConfig handlerConfig, Object o, String methodName) {
		try {
			Method m = o.getClass().getMethod(methodName, null);
			return m.invoke(o, null);
		} catch (Exception e) {
			System.out.println(o.getClass());
			System.out.println(methodName);
			throw new RuntimeException(e);

		}
	}

	/**
	 * 触发handler方法返回的对象的display方法。
	 * 
	 * @param handlerConfig
	 * @param view
	 */
	private void invokeDisplay(HandlerConfig handlerConfig, Object view) {
		try {
			Method m = view.getClass().getMethod("display", null);
			m.invoke(view, null);
		} catch (Exception e) {
		}
	}

	/**
	 *
	 */
	class HandlerConfig {
		private String path;
		private String clazz;
		private String method;
		private Map<String, ViewConfig> views = new HashMap<String, ViewConfig>();

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public String getClazz() {
			return clazz;
		}

		public void setClazz(String clazz) {
			this.clazz = clazz;
		}

		public String getMethod() {
			return method;
		}

		public void setMethod(String method) {
			this.method = method;
		}

		public void putView(String name, ViewConfig v) {
			views.put(name, v);
		}

		public ViewConfig getView(String name) {
			return this.views.get(name);
		}
	};

	class ViewConfig {
		private String name;
		private String type;
		private String value;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String toString() {
			return name + "_" + type + "_" + value;
		}
	}
}

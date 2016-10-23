package com.yuqiaotech.helloj2ee.mvc;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 参看了struts2的代码。
 */
public class SimpleRequestWrapper extends HttpServletRequestWrapper {

	public SimpleRequestWrapper(HttpServletRequest req) {
		super(req);
	}

	/**
	 * 在jsp页面里使用${xxx}的时候，会调用到reuqest.getAttribute("xxx")，但我们希望如果request的
	 * attribute集合里没有的话，再去尝试调用我们的handler的getXxx方法。所以我们对request进行保证，
	 * 然后在forward的时候用本包装后的对象替换原来的request对象。
	 *
	 * @param s
	 *            The attribute key
	 */
	public Object getAttribute(String s) {
		if (s != null && s.startsWith("javax.servlet")) {
			// don't bother with the standard javax.servlet attributes, we can
			// short-circuit this
			// see WW-953 and the forums post linked in that issue for more info
			return super.getAttribute(s);
		}
		Object r = super.getAttribute(s);
		if (r != null)
			return r;
		StringBuffer sb = new StringBuffer(3 + s.length());
		sb.append("get");
		sb.append(Character.toUpperCase(s.charAt(0)));
		sb.append(s.substring(1));
		String methodName = sb.toString();

		Object handler = MvcContext.getHandler();
		Method m = null;
		try {
			m = handler.getClass().getMethod(methodName, null);
		} catch (SecurityException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (NoSuchMethodException e) {
			return null;
		}
		try {
			if (m == null)
				return null;
			r = m.invoke(handler, null);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return r;
	}
}

package edu.jiangxin.statistics.filter;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import edu.jiangxin.statistics.bean.LogBean;
import edu.jiangxin.statistics.service.LogService;

public class LogFilter implements Filter {

	Logger logger = LogManager.getLogger(LogFilter.class);

	@Autowired
	private LogService logService;

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		if (!(servletRequest instanceof HttpServletRequest) || !(servletResponse instanceof HttpServletResponse)) {
			throw new ServletException("OncePerRequestFilter just supports HTTP requests");
		}

		HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
		HttpSession session = httpRequest.getSession();
		String ip = httpRequest.getRemoteAddr();
		String page = httpRequest.getRequestURI();
		String contextPath = httpRequest.getContextPath();
		String servletPath = httpRequest.getServletPath();

		logger.info("doFilter sessionId=" + session.getId() + ",ip=" + ip + ",page=" + page + ",contextPath="
				+ contextPath + ",servletPath=" + servletPath);

		LogBean logBean = new LogBean();
		logBean.setId(UUID.randomUUID().toString());
		logBean.setSessionId(session.getId());
		logBean.setIp(ip);
		logBean.setPage(page);
		logBean.setAccessTime(new Timestamp(new Date().getTime()));
		logBean.setStayTime(0);

		//通过session id 和 ip，查出最近的一条访问记录
		LogBean bean = null;
		try {
			bean = logService.getLatestLog(session.getId(), ip);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		//更改最近访问记录的停留时间，这里把两次访问记录的间隔时间算成上一次页面访问的停留时间
		if (bean != null) {
			long stayTime = (System.currentTimeMillis() - bean.getAccessTime().getTime()) / 1000;
			try {
				logService.updateLog(bean.getId(), stayTime);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			}
		}

		//保存当前访问记录
		try {
			logService.saveLog(logBean);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		//统计网站的PV（页面浏览量），UV（独立访客数）
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String format = df.format(new Date());
		Date parse = null;
		try {
			parse = df.parse(format);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		Timestamp startTime = new Timestamp(parse.getTime());
		Timestamp endTime = new Timestamp(parse.getTime() + 24 * 3600 * 1000);
		try {
			int pv = logService.getPV(startTime, endTime);
			int uv = logService.getUV(startTime, endTime);
			logger.info("pv=" + pv);
			logger.info("uv=" + uv);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		filterChain.doFilter(servletRequest, servletResponse);
		return;
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext context = filterConfig.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
		logService = (LogService) ctx.getBean("logService");
		logger.info("init");
	}

	public void destroy() {
	}
}

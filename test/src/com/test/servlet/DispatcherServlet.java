package com.test.servlet;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class DispatcherServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		Properties ps = new Properties();

		try {
			ServletContext context = config.getServletContext();
			InputStream in = context.getResourceAsStream("/WEB-INF/messageresource.properties");
			ps.load(in);

			in.close();

			context.setAttribute("ps", ps);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void destroy() {
	}
}
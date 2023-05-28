package com.shengsiyuan.servlet;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitServlet2 extends HttpServlet
{
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		Properties ps = new Properties();

		try
		{
			ServletContext context = config.getServletContext();

			InputStream is = context
					.getResourceAsStream("/WEB-INF/message.properties");

			ps.load(is);

			is.close();

			// 将properties对象放置到application范围内供其他组件使用
			context.setAttribute("ps", ps);

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}















	}

}

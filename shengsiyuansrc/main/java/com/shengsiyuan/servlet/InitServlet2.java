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
			
			// ��properties������õ�application��Χ�ڹ��������ʹ��
			context.setAttribute("ps", ps);
			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

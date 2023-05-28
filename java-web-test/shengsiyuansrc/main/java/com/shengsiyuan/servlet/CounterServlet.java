package com.shengsiyuan.servlet;


import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounterServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		ServletContext context = req.getSession().getServletContext();
		
		if(null == context.getAttribute("counter"))
		{
			context.setAttribute("counter", 1);
		}
		else
		{
			int counter = (Integer)context.getAttribute("counter");
			
			context.setAttribute("counter", counter + 1);
		}
		
		req.getRequestDispatcher("counter.jsp").forward(req, resp);
	}

}

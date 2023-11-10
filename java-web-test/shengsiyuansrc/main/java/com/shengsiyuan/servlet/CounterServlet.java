package com.shengsiyuan.servlet;


import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

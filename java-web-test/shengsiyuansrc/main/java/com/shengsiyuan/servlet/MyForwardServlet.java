package com.shengsiyuan.servlet;


import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyForwardServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{

		
//		String username = req.getParameter("username");
		
//		req.setAttribute("username", username);
		
		resp.sendRedirect("myResult.jsp");
		
//		RequestDispatcher rd = req.getRequestDispatcher("myResult.jsp");
//		
//		rd.forward(req, resp);
		
		
		
		

//		
//		
//		List<String> list = new ArrayList<String>();
//		
//		for(int i = 0; i < 100; i++)
//		{
//			list.add(String.valueOf(i));
//		}
//		
//		req.setAttribute("list", list);
//		
//		
//		RequestDispatcher rd = req.getRequestDispatcher("myResult.jsp");
//		
//		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		this.doGet(req, resp);
	}
}

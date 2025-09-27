package com.shengsiyuan.servlet;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServiceServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println(username + " = " + password);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("doGet invoked!");
		System.out.println(username + " = " + password);
	}
	
	
	
	
	
	
	
	
	
}

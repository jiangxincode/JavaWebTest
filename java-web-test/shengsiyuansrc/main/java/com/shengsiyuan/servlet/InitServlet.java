package com.shengsiyuan.servlet;


import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InitServlet extends HttpServlet
{
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		System.out.println("init invoked!");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		System.out.println("doGet invoked!");
	}
	
	@Override
	public void destroy()
	{
		System.out.println("destroy invoked!");
	}      
}      











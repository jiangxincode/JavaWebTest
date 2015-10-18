package com.shengsiyuan.servlet;


import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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











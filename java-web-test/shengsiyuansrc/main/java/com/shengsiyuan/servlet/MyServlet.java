package com.shengsiyuan.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		int param1 = Integer.parseInt(req.getParameter("param1"));
		int param2 = Integer.parseInt(req.getParameter("param2"));
		
		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-control", "no-cache");

		PrintWriter out = resp.getWriter();
		
		out.println(String.valueOf(param1 + param2));
		
		out.flush();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		this.doPost(req, resp);
	}
}

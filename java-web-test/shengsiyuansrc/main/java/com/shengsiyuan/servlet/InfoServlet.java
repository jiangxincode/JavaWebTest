package com.shengsiyuan.servlet;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InfoServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		System.out.println(req.getParameter("username"));
		
		req.getRequestDispatcher("infoResult.jsp").forward(req, resp);
	}
}

package com.shengsiyuan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet
{
	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html><head><title>Hello World Sample</title></head>");

		out.println("<body><h1>Test Servlet: " + new Date().toLocaleString()
				+ "</h1></body></html>");

		System.out.println(new Date().toLocaleString());

		out.flush();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		this.doGet(request, response);
	}

}

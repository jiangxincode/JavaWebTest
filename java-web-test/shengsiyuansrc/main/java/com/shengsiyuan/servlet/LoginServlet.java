package com.shengsiyuan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		System.out.println("doGet invoked!");
		
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		System.out.println("doPost invoked!");
		
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp)
			throws IOException
	{
		System.out.println(req);
		System.out.println(resp);

		String username = req.getParameter("username1");
		String password = req.getParameter("password1");

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		out.println("<html><head><title>Login Result</title></head>");

		out.println("<body> username: " + username + "<br>");
		out.println("password: " + password + "</body></html>");

		out.flush();
	}
}

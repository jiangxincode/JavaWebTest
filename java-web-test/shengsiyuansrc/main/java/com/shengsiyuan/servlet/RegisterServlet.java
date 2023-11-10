package com.shengsiyuan.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String repassword = req.getParameter("repassword");
		int age = Integer.parseInt(req.getParameter("age"));
		
		String result = "";
		
		if(password.equals(repassword) && age > 18)
		{
			result += "success";
		}
		
		if(!password.equals(repassword))
		{
			result += "password != repassword";
		}
		
		if(age <= 18)
		{
			result += " age <= 18";
		}
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html><head><title>registration result</title></head>");
		out.println("<body><h1>" + result + "</h1></body></html>");
		
		out.flush();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		this.doGet(req, resp);
	}
}

















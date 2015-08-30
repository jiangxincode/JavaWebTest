package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeServlet extends HttpServlet
{
	int ini = 0;

	int ser = 0;

	int des = 0;

	public void init(ServletConfig config) throws ServletException
	{
		ini++;
		System.out.println("init: " + "The Servlet begins times=" + (ini));

	}

	public void destroy()
	{
		des++;
		System.out
				.println("destroy: " + "The Servlet destroyed times=" + (des));
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		PrintWriter out;
		ser++;
		System.out
				.println("service: "
						+ "The Servlet are processing request                           times="
						+ (ser));
		String title = "Servlet Life Cycle Demo Page";
		String heading1 = "Init times : " + ini;
		String heading2 = "Service times : " + ser;
		String heading3 = "Destroy times : " + des;
		// set content type.
		response.setContentType("text/html");    
		// write data or building web page.
		out = response.getWriter();
		out.print("<HTML><HEAD><TITLE>" + title + "</TITLE>");
		out.print("</HEAD><BODY>");
		out.print("<h1>" + heading1 + "</h1>");
		out.print("<h1>" + heading2 + "</h1>");
		out.print("<h1>" + heading3 + "</h1>");
		out.print("</BODY></HTML>");
		// close out.
		out.close();
	}
}
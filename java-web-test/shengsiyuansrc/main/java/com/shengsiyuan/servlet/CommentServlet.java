package com.shengsiyuan.servlet;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CommentServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		//String username = (String)req.getAttribute("username");
		//String comment = (String)req.getAttribute("comment");
		
		req.getRequestDispatcher("commentResult.jsp").forward(req, resp);
		
	}
}

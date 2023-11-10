package com.shengsiyuan.servlet;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet
{
//	private String username;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		String username = req.getParameter("username");

		//得到当前线程的名字
		System.out.println(Thread.currentThread().getName());

		//进行一些后端的业务处理
		try
		{
			Thread.sleep(10000);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

		req.setAttribute("username", username);
		req.getRequestDispatcher("hello.jsp").forward(req, resp);
	}
}

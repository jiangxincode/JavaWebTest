package com.shengsiyuan.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet
{
//	private String username;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		String username = req.getParameter("username");
		
		//�õ���ǰ�̵߳�����
		System.out.println(Thread.currentThread().getName());
		
		//����һЩ��˵�ҵ����
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

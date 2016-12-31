package com.shengsiyuan.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		this.process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		this.process(req, resp);
	}

	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		req.setCharacterEncoding("utf-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String[] interest = req.getParameterValues("interest");
		String address = req.getParameter("address");
		
		address = new String(address.getBytes("iso-8859-1"), "utf-8");
		
		System.out.println(req);
		
		String comment = req.getParameter("comment");
		
		List<String> list = new ArrayList<String>();
		
		if(null == username || "".equals(username))
		{
			list.add("�û�������Ϊ�գ�");
		}
		else if (username.length() < 4)
		{
			list.add("�û������̣�");
		}
		else if(username.length() > 10)
		{
			list.add("�û���������");
		}
		
		if(null == password || "".equals(password))
		{
			list.add("���벻��Ϊ�գ�");
		}
		else if(password.length() < 4)
		{
			list.add("������̣�");
		}
		else if(password.length() > 10)
		{
			list.add("�������!");
		}
		if(null == gender)
		{
			list.add("�Ա�û��ѡ��!");
		}
		
		if(null == interest)
		{
			list.add("��Ȥ����ѡ��һ����");
		}
		else if(interest.length > 3)
		{
			list.add("��Ȥ���ѡ��������");
		}
		if(null == comment || "".equals(comment))
		{
			list.add("˵��û����д��");
		}
		
		resp.setCharacterEncoding("utf-8");
		
		if(list.isEmpty())
		{
			req.setAttribute("username", username);
			req.setAttribute("password", password);
			req.setAttribute("gender", gender);
			req.setAttribute("interest", interest);
			req.setAttribute("address", address);
			req.setAttribute("comment", comment);
			
			req.getRequestDispatcher("loginSuccess.jsp").forward(req, resp);
		}
		else
		{
			req.setAttribute("error", list);
			
			req.getRequestDispatcher("loginFailure.jsp").forward(req, resp);
		}
	}

}

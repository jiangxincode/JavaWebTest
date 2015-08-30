package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounterServlet extends HttpServlet
{
	private static final String CONTENT_TYPE = "text/html";

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		System.out.println("init invoked");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		// ���ServletContext������
		ServletContext context = getServletContext();
		// ��ServletContext��ȡcount����
		Integer count = (Integer) context.getAttribute("count");

		// ���count���Ի�û������, ��ô����count���ԣ���ʼֵΪ0
		// one and add it to the ServletContext
		if (count == null)
		{
			count = new Integer(0);
			context.setAttribute("count", new Integer(0));
		}

		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>WebCounter</title></head>");
		out.println("<body>");
		// �����ǰ��count����ֵ
		out.println("<p><h1>The current COUNT is : " + count + ".</h1></p>");
		out.println("</body></html>");

		// �����µ�count������ֵ��1
		count = new Integer(count.intValue() + 1);
		// ���µ�count���Դ洢��ServletContext��
		context.setAttribute("count", count);
	}

	public void destroy()
	{
		
	}
}
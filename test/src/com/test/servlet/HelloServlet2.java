package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet2 extends HttpServlet // ��һ���� ��չ HttpServlet �����ࡣ
{
	// String clientName = null;

	// �ڶ���������doGet()����

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// ����������ȡHTTP �����еĲ�����Ϣ
		String clientName = request.getParameter("clientName");
		if (clientName != null) {
			clientName = new String(clientName.getBytes("ISO-8859-1"), "GB2312");
		} else {
			clientName = "�ҵ�����";
		}

		System.out.println(Thread.currentThread().getName());

		try {
			Thread.sleep(10000);
		} catch (Exception e) {
		}

		// ���Ĳ������� HTTP ��Ӧ�����
		PrintWriter out;
		String title = "HelloServlet";
		String heading1 = "This is output from HelloServlet by doGet:";
		// set content type.
		response.setContentType("text/html;charset=GB2312");
		// write html page.
		out = response.getWriter();
		out.print("<HTML><HEAD><TITLE>" + title + "</TITLE>");
		out.print("</HEAD><BODY>");
		out.print(heading1);
		out.println("<h1><P> " + clientName + " : ����</h1>");
		out.print("</BODY></HTML>");
		// close out.
		out.close();

	}
}
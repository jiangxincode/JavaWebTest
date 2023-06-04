package test.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@SuppressWarnings("deprecation")
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getClass().getName());
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<HTML><HEAD><TITLE>My First Servlet</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<H1>Hello World</H1>");
		out.println("<br>" + new java.util.Date().toLocaleString());
		out.println("</BODY></HTML>");

		System.out.println("当前系统时间为：" + new java.util.Date().toLocaleString());
	}

}

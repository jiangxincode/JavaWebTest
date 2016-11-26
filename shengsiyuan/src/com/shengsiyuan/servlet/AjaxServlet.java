package com.shengsiyuan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet invoked");

		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String v1 = req.getParameter("v1");
		String v2 = req.getParameter("v2");

		System.out.println("v1=" + v1 + ", v2=" + v2);

		String v3 = String.valueOf(Integer.valueOf(v1) + Integer.valueOf(v2));

		PrintWriter out = resp.getWriter();

		// try
		// {
		// Thread.sleep(5000);
		// }
		// catch (InterruptedException e)
		// {
		// e.printStackTrace();
		// }

		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-control", "no-cache");

		out.println(v3);

		out.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost invoked");

		this.process(req, resp);
	}
}

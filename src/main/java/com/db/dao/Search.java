package com.db.dao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.dao.AuthorDAO;

/**
 * Servlet implementation class for Servlet: Search
 *
 */
public class Search extends HttpServlet implements Servlet {
	static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		if (type.equals("1")) {
			long count = AuthorDAO.getCount();
			request.setAttribute("result", count);
			ServletContext sc = this.getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/JSP/MongoDB/mongodb.jsp");
			rd.forward(request, response);
			System.out.println("type:" + 1);
		} else if (type.equals("2")) {
			request.setAttribute("result", 2222222);
			ServletContext sc = this.getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/JSP/MongoDB/mongodb.jsp");
			rd.forward(request, response);
			System.out.println("type:" + 2);
		} else if (type.equals("3")) {

		} else if (type.equals("4")) {

		}
	}
}
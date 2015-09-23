package com.test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int count1 = 0;

	private int count2 = 0;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie cookie = new Cookie("cookieName" + count1++, "cookieValue" + count2++);
		cookie.setMaxAge(10);
		response.addCookie(cookie);

		Cookie[] cookies = request.getCookies();

		if (cookies == null)
			return;
		for (int i = 0; i < cookies.length; i++) {

			System.out.println("Cookie Name :" + cookies[i].getName());
			System.out.println("Cookie Value :" + cookies[i].getValue());
		}

	}

}

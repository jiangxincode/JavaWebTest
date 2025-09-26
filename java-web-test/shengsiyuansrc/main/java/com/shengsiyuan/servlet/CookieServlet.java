package com.shengsiyuan.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet
{
	private int count1;

	private int count2;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		Cookie cookie = new Cookie("cookieName" + count1++, "cookieValue"
				+ count2++);
		
		cookie.setMaxAge(15);
		
		resp.addCookie(cookie);
		
		Cookie[] cookies = req.getCookies();
		
		if(null == cookies)
		{
			return;
		}
		
		for(Cookie c : cookies)
		{
			System.out.println("cookie name: " + c.getName());
			System.out.println("cookie value: " + c.getValue());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

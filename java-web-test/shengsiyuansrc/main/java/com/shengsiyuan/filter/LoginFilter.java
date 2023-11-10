package com.shengsiyuan.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginFilter implements Filter
{
	public void destroy()
	{

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest r = (HttpServletRequest) request;

		String requestURI = r.getRequestURI();

		if (requestURI.endsWith("login.jsp")
				|| requestURI.endsWith("MyLoginServlet"))
		{
			chain.doFilter(request, response);
			return;
		}

		HttpSession session = r.getSession();

		if (null == session.getAttribute("user"))
		{
			((HttpServletResponse) response).sendRedirect("login.jsp");
			return;
		}
		else
		{
			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException
	{
		System.out.println("Filter started!");
	}

}

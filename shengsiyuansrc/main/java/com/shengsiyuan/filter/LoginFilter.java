package com.shengsiyuan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

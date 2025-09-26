package com.shengsiyuan.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CommentFilter implements Filter
{

	public void destroy()
	{
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String username = req.getParameter("username");
		String comment = req.getParameter("comment");
		
		username = username.replace("zhang", "li");
		comment = comment.replace("shengsiyuan", "****");
		
		req.setAttribute("username", username);
		req.setAttribute("comment", comment);
		
		chain.doFilter(request, response);
		
	}
	
	
	

	

	public void init(FilterConfig filterConfig) throws ServletException
	{
		String value1 = filterConfig.getInitParameter("hello");
		String value2 = filterConfig.getInitParameter("zhang");
		
		System.out.println(value1 + "," + value2);
		
		ServletContext context = filterConfig.getServletContext();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

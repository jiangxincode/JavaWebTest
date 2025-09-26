package com.shengsiyuan.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MyFilter2 implements Filter
{

	public void destroy()
	{
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		System.out.println("myFilter2 before chain.doFilter");

		chain.doFilter(request, response);

		System.out.println("myFilter2 after chain.doFilter");

	}

	public void init(FilterConfig filterConfig) throws ServletException
	{
		// TODO Auto-generated method stub

	}

}

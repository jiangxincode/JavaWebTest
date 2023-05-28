package com.shengsiyuan.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener
{
	public void sessionCreated(HttpSessionEvent se)
	{
		System.out.println("session created");
		
		System.out.println(se.getSession());
	}

	public void sessionDestroyed(HttpSessionEvent se)
	{
		System.out.println("session destroyed");
		
		System.out.println(se.getSession());
	}

}

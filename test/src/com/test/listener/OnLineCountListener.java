package com.test.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnLineCountListener implements HttpSessionListener,
		ServletContextListener, ServletContextAttributeListener
{
	private int count;

	public void sessionCreated(HttpSessionEvent arg0)
	{
		count++;
		setContext(arg0);
		System.out.println("count");

	}

	public void sessionDestroyed(HttpSessionEvent arg0)
	{
		count--;
		setContext(arg0);

	}

	public void setContext(HttpSessionEvent se)
	{
		se.getSession().getServletContext().setAttribute("onLine",
				new Integer(count));
	}

	public void contextInitialized(ServletContextEvent arg0)
	{
		log("contextInitialized()");

	}

	public void contextDestroyed(ServletContextEvent arg0)
	{
		log("contextDestroyed()");
	}

	public void attributeAdded(ServletContextAttributeEvent arg0)
	{
		log("attributeAdded('" + arg0.getName() + "', '" + arg0.getValue()
				+ "')");

	}

	public void attributeRemoved(ServletContextAttributeEvent arg0)
	{
		log("attributeRemoved('" + arg0.getName() + "', '" + arg0.getValue()
				+ "')");

	}

	public void attributeReplaced(ServletContextAttributeEvent arg0)
	{
		log("attributeReplaced('" + arg0.getName() + "', '" + arg0.getValue()
				+ "')");

	}

	private void log(String message)
	{

		System.out.println("ContextListener: " + message);
	}

}

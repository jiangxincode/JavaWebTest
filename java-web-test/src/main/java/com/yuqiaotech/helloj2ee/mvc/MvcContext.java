package com.yuqiaotech.helloj2ee.mvc;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 这里主要是通过ThreadLocal技术，使得在一个线程之内，可以方便的 访问request，response等对象，而不是通过一层层的传输传递。
 * 
 * TODO 是否可以更像struts2一些？
 *
 */
public class MvcContext {
	public static final ThreadLocal<MvcServletContext> context = new ThreadLocal<MvcServletContext>();

	public static HttpServletRequest getRequest() {
		return context.get().getRequest();
	}

	public static HttpSession getSession() {
		return context.get().getRequest().getSession();
	}

	public static Map getSessionMap() {
		return context.get().getSessionMap();
	}

	public static ServletContext getApplication() {
		return context.get().getRequest().getSession().getServletContext();
	}

	public static HttpServletResponse getResponse() {
		return context.get().getResponse();
	}

	public static Object getHandler() {
		return context.get().getHandler();
	}
}

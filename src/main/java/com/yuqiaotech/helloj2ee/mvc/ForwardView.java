package com.yuqiaotech.helloj2ee.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardView {

	private String forwardTo;

	public ForwardView(String forwardTo) {
		this.forwardTo = forwardTo;
	}

	public void display() {
		HttpServletRequest request = MvcContext.getRequest();
		HttpServletResponse response = MvcContext.getResponse();
		try {
			request.getRequestDispatcher(forwardTo).forward(request, response);
		} catch (ServletException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}

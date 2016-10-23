package com.yuqiaotech.helloj2ee.mvc;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 * 发送Location头信息的转向方式。
 *
 */
public class RedirectView {

	private String redirect;

	public RedirectView(String redirect) {
		this.redirect = redirect;
	}

	public void display() {
		HttpServletResponse response = MvcContext.getResponse();
		try {
			response.sendRedirect(redirect);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}

package com.yuqiaotech.helloj2ee.mvc.handler;

import javax.servlet.http.HttpServletRequest;

import com.yuqiaotech.helloj2ee.mvc.ForwardView;
import com.yuqiaotech.helloj2ee.mvc.MvcContext;

/**
 * 一个使用我们自己的mvc写的一个简单的例子。
 *
 */
public class HelloHandler {
	private String paramTest;

	public ForwardView handle() {
		HttpServletRequest request = MvcContext.getRequest();
		request.setAttribute("msg", "hello mvc.");
		return new ForwardView("/mvc/hello.jsp");
	}

	public String getTestStr() {
		return "paramTest=" + paramTest;
	}

	public String getParamTest() {
		return paramTest;
	}

	public void setParamTest(String paramTest) {
		this.paramTest = paramTest;
	}

}

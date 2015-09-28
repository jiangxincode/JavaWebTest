package com.test.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class MyInterceptor implements Interceptor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hello;

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}

	public void destroy() {
		System.out.println("destroy invoked");
	}

	public void init() {
		System.out.println("init invoked");
		System.out.println("hello:" + hello);
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		invocation.addPreResultListener(new PreResultListener() {
			public void beforeResult(ActionInvocation invocation, String resultCode) {
				System.out.println("hello world");
			}
		});

		System.out.println("intercept invoked");

		String result = invocation.invoke();

		System.out.println(result);

		return result;
	}

}

package com.test.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyInterceptor3 extends MethodFilterInterceptor
{
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception
	{
		System.out.println("myInterceptor3 invoked");
		
		String result = invocation.invoke();
		
		System.out.println("result3 : " + result);
		
		return result;
		
	}

}

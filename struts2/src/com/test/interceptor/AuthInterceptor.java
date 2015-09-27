package com.test.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor
{
	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception
	{
		Map map = invocation.getInvocationContext().getSession();
		
		if(null == map.get("user")) //�û�û�е�¼
		{
			return Action.LOGIN; //���ص���¼����
		}
		else
		{
			return invocation.invoke();
		}
	}

}

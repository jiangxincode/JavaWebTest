package lee.aopproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroundInterceptor implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("调用方法之前：invocation对象：[" + arg0 + "]");
		Object rval = arg0.proceed();
		System.out.println("调用结束");
		return rval;
	}

}

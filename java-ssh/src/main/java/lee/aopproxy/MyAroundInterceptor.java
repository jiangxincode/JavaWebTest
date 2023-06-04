package lee.aopproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroundInterceptor implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("���÷���֮ǰ��invocation����[" + arg0 + "]");
		Object rval = arg0.proceed();
		System.out.println("���ý���");
		return rval;
	}

}

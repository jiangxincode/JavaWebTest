package lee;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MyAfterAdvisor implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("方法调用结束...");
		System.out.println("目标方法的返回值是：" + arg0);
		System.out.println("目标方法是：" + arg1);
		System.out.println("目标方法的参数是：" + arg2);
		System.out.println("目标对象是： " + arg3);
		
	}

}
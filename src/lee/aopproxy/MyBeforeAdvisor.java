package lee.aopproxy;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvisor implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("方法调用之前...");
		System.out.println("下面是方法调用的信息：");
		System.out.println("所执行的方法是：" + arg0);
		System.out.println("调用方法的参数是：" + arg1);
		System.out.println("目标对象是： " + arg2);
		
	}

}

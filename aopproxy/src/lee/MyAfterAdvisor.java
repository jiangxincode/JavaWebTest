package lee;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MyAfterAdvisor implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("�������ý���...");
		System.out.println("Ŀ�귽���ķ���ֵ�ǣ�" + arg0);
		System.out.println("Ŀ�귽���ǣ�" + arg1);
		System.out.println("Ŀ�귽���Ĳ����ǣ�" + arg2);
		System.out.println("Ŀ������ǣ� " + arg3);
		
	}

}
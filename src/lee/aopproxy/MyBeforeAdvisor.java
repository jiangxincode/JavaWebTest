package lee.aopproxy;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvisor implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("��������֮ǰ...");
		System.out.println("�����Ƿ������õ���Ϣ��");
		System.out.println("��ִ�еķ����ǣ�" + arg0);
		System.out.println("���÷����Ĳ����ǣ�" + arg1);
		System.out.println("Ŀ������ǣ� " + arg2);
		
	}

}

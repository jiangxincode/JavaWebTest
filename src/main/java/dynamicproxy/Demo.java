package dynamicproxy;

import java.lang.reflect.Proxy;

public class Demo {
	public static void main(String[] args) {

		// 1.ͨ�õĶ�̬����ʵ��

		CommonInvocationHandler handler = new CommonInvocationHandler();

		Foo f;

		// 2.�ӿ�ʵ��1

		handler.setTarget(new FooImpl());

		// ��������˵���������ࡢ������ʵ�ֵĽӿ��б�������Ĵ�����

		// ���������ࡢ�������нӿڷ����������������������нӿڷ���������ʱ�����Զ��ַ�����������invoke����

		// ���������û��ʵ��ָ���ӿ��б����׳��Ƿ������쳣

		f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),

				new Class[] { Foo.class },

				handler);

		f.doAction();

		// 3.�ӿ�ʵ��2

		handler.setTarget(new FooImpl2());

		f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),

				new Class[] { Foo.class },

				handler);

		f.doAction();
	}
}

package com.test.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Vector;

public class VectorProxy implements InvocationHandler {
	private Object proxyobj;

	public VectorProxy(Object obj) {
		proxyobj = obj;
	}

	public static Object factory(Object obj) {
		Class<?> cls = obj.getClass();

		return Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), new VectorProxy(obj));
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before calling " + method);

		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				System.out.println(args[i] + "");
			}
		}
		Object object = method.invoke(proxyobj, args);

		System.out.println("after calling " + method);
		return object;
	}

	public static void main(String[] args) {
		List v = null;
		v = (List) factory(new Vector());

		v.add("New");
		v.add("York");
		System.out.println(v);

		v.remove(0);
		System.out.println(v);
	}
}

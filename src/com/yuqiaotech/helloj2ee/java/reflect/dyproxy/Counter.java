package com.yuqiaotech.helloj2ee.java.reflect.dyproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//import org.apache.commons.beanutils.BeanUtils;

public class Counter implements InvocationHandler {

	private Object target;
	private int sellCount;
	private int buyCPUCount;

	public Counter(Object target) {
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// String tName = "";
		// Intercepter t = IntercepterFactory.getIntercepter(tName);
		// t.before();
		// System.out.println(BeanUtils.describe(proxy.getClass()));
		String methodName = method.getName();
		if (methodName.equals("sellComputer")) {
			sellCount++;
		} else if (methodName.equals("buyCPU")) {
			buyCPUCount += ((Integer) args[1]);
		}
		method.invoke(target, args);
		// t.after();
		return null;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public int getSellCount() {
		return sellCount;
	}

	public int getBuyCPUCount() {
		return buyCPUCount;
	}

	// interface Intercepter{
	// void before();
	// void after();
	//		
	// }
	// static class IntercepterFactory{
	// public static Intercepter getIntercepter(String intercepterName){
	// return null;
	// }
	//		
	// }
}

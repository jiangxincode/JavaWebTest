package com.shengsiyuan.lesson061.reflect;

import java.lang.reflect.Method;

public class DumpMethods {
	public static void main(String[] args) throws Exception {
		Class<?> classType = Class.forName(args[0]);

		Method[] methods = classType.getDeclaredMethods();

		for (Method method : methods) {
			System.out.println(method);
		}
	}
}

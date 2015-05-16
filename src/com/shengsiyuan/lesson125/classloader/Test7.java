package com.shengsiyuan.lesson125.classloader;

class CL {
	static {
		System.out.println("Class CL");
	}
}

public class Test7 {
	public static void main(String[] args) throws Exception {
		// ���ϵͳ�������
		ClassLoader loader = ClassLoader.getSystemClassLoader();

		@SuppressWarnings("unused")
		Class<?> clazz = loader.loadClass("com.shengsiyuan.classloader.CL");

		System.out.println("----------------------------");

		clazz = Class.forName("com.shengsiyuan.classloader.CL");
	}

}
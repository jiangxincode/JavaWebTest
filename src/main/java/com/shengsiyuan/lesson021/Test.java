package com.shengsiyuan.lesson021;

public class Test {
	public static void main(String[] args) {
		// R r = new R();
	}
}

abstract class T {
	public abstract void method(); // 有声明无实现

	public void test() {
		System.out.println("test");
	}
}

abstract class R extends T {
	public void method() {
		System.out.println("method");
	}
}

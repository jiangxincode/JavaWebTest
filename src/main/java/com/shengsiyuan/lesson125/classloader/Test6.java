﻿package com.shengsiyuan.lesson125.classloader;

class Parent3 {
	static int a = 3;

	static {
		System.out.println("Parent3 static block");
	}

	static void doSomething() {
		System.out.println("do something");
	}
}

class Child3 extends Parent3 {
	static {
		System.out.println("Child3 static block");
	}
}

public class Test6 {
	public static void main(String[] args) {
		System.out.println(Child3.a);

		Child3.doSomething();
	}
}

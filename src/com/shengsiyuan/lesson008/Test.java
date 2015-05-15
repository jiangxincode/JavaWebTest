package com.shengsiyuan.lesson008;

public class Test {
	static {
		System.loadLibrary("HelloWorld");// 不要加后缀名
	}

	public native void output();

	public static void main(String[] args) {
		Test test = new Test();
		test.output();
	}
}

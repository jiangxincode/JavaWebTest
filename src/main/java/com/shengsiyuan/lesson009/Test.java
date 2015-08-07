package com.shengsiyuan.lesson009;

public class Test {
	// 两个整数相加的方法
	public int add(int a, int b) {
		return a + b;
	}

	// 两个整数相减的方法
	public int subtract(int a, int b) {
		return a - b;
	}

	// 两个整数相乘的方法
	public int multiply(int a, int b) {
		return a * b;
	}

	// 两个整数相除的方法
	public int divide(int a, int b) {
		return a / b;
	}

	// 使用void关键字表示方法不返回值
	public void output() {
		System.out.println("Hello World");
	}

	public void method(int a) {
		if (a < 10) {
			return;
		}

		System.out.println("Welcome to Shengsiyuan!!");
	}

	public static void main(String[] args) {
		Test test = new Test();

		int x = 8;
		int y = 3;

		int a = test.add(x, y);
		int b = test.subtract(x, y);
		int c = test.multiply(x, y);
		int d = test.divide(x, y);

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);

		test.output();

		int m = 15;

		test.method(m);

	}
}

package com.shengsiyuan.lesson009;

public class Test {
	// ����������ӵķ���
	public int add(int a, int b) {
		return a + b;
	}

	// ������������ķ���
	public int subtract(int a, int b) {
		return a - b;
	}

	// ����������˵ķ���
	public int multiply(int a, int b) {
		return a * b;
	}

	// ������������ķ���
	public int divide(int a, int b) {
		return a / b;
	}

	// ʹ��void�ؼ��ֱ�ʾ����������ֵ
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

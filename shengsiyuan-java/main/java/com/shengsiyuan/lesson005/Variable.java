package com.shengsiyuan.lesson005;

public class Variable {
	public static void main(String[] args) {
		int a = 3;
		// a = a + 1;

		// a += 1; // 等价于 a = a + 1;

		// a++;

		// ++a;

		// a = a + 2;
		// a += 2;

		int b = ++a;

		a++;
		--a;
		--a;

		System.out.println(a);
		System.out.println(b);
	}
}
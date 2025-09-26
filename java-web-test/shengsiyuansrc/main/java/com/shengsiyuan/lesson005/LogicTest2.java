package com.shengsiyuan.lesson005;

public class LogicTest2 {
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int f = 5;

		@SuppressWarnings("unused")
		boolean e = (a > b) && ((f = c) < d);

		// System.out.println(e);
		// System.out.println(f);

		boolean g = (a > b) || ((f = c) < d);

		System.out.println(g);
		System.out.println(f);
	}
}
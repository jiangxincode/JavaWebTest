package com.shengsiyuan.lesson005;

public class LogicTest {
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;

		/*
		 * boolean e = (a > b) && (c < d); System.out.println(e);
		 */

		boolean e = (a > b) || (c > d);
		System.out.println(e);
	}
}
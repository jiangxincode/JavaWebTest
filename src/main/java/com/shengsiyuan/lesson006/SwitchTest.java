package com.shengsiyuan.lesson006;

public class SwitchTest {
	public static void main(String[] args) {
		int a = 3;

		switch (a) {
		case 3:
			System.out.println("a == 3");
			break;
		case 1:
			System.out.println("a == 1");
			break;
		case 2:
			System.out.println("a == 2");
			break;
		default:
			System.out.println("default");
		}

		if (3 == a) {
			System.out.println("a == 3");
		} else if (1 == a) {
			System.out.println("a == 1");
		} else if (2 == a) {
			System.out.println("a == 2");
		} else {
			System.out.println("default");
		}

	}
}

package com.shengsiyuan.lesson007;

public class DoWhileTest {
	public static void main(String[] args) {
		int a = 2;// ѭ������
		int sum = 0; // �洢��Ӻ�Ľ��

		do {
			sum += a;
			a += 2;
		} while (a <= 100);

		System.out.println(sum);

		int b = 2;

		while (b < 1) {
			System.out.println("Hello World");
		}

		do {
			System.out.println("Welcome");
		} while (b < 1);

	}
}

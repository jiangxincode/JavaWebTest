package com.shengsiyuan.lesson007;

public class WhileTest {
	public static void main(String[] args) {
		int a = 2; // ѭ������
		int sum = 0; // �洢��Ӻ�Ľ��

		while (a <= 100) {
			sum += a;
			a += 2;
		}

		System.out.println(sum);

	}
}

package com.shengsiyuan.lesson007;

public class ForTest {
	public static void main(String[] args) {
		int sum = 0; // �洢��Ӻ�Ľ��

		for (int i = 2; i <= 100; i += 2) {
			sum += i;
		}

		System.out.println(sum);

		int sum2 = 0; // �洢��Ӻ�Ľ��

		for (int i = 100; i >= 1; i--) {
			sum2 += i;
		}

		System.out.println(sum2);

	}
}

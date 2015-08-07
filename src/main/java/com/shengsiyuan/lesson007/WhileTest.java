package com.shengsiyuan.lesson007;

public class WhileTest {
	public static void main(String[] args) {
		int a = 2; // 循环变量
		int sum = 0; // 存储相加后的结果

		while (a <= 100) {
			sum += a;
			a += 2;
		}

		System.out.println(sum);

	}
}

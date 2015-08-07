package com.shengsiyuan.lesson008;

public class BreakContinueTest {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			if (1 == i) {
				break;
			}

			for (int j = 0; j <= i; ++j) {
				if (1 == j) {
					continue;
				}

				System.out.println("j=" + j);
			}

			System.out.println("i=" + i);
		}
	}
}

package com.shengsiyuan.lesson059;

public class ShowEnum2 {
	public static void main(String[] args) {
		for (OpConstant c : OpConstant.values()) {
			System.out.printf("%d, %s, %n", c.ordinal(), c);
		}
	}
}

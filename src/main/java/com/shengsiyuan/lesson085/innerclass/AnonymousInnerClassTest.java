package com.shengsiyuan.lesson085.innerclass;

import java.util.Date;

public class AnonymousInnerClassTest {
	@SuppressWarnings("deprecation")
	public String get(Date date) {
		return date.toLocaleString();
	}

	public static void main(String[] args) {
		AnonymousInnerClassTest test = new AnonymousInnerClassTest();

		// String str = test.get(new Date());;

		// System.out.println(str);

		@SuppressWarnings("serial")
		String str = test.get(new Date() {
			public String toLocaleString() {
				return "hello world";
			}
		});

		System.out.println(str);

	}

}

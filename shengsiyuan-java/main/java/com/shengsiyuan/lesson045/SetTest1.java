package com.shengsiyuan.lesson045;

import java.util.HashSet;

public class SetTest1 {
	public static void main(String[] args) {
		HashSet<Object> set = new HashSet<Object>();

		System.out.println(set.add("a"));
		set.add("b");
		set.add("c");
		set.add("d");
		System.out.println(set.add("a"));

		System.out.println(set);

	}
}

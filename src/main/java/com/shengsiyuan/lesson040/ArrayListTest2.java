package com.shengsiyuan.lesson040;

import java.util.ArrayList;

public class ArrayListTest2 {
	public static void main(String[] args) {
		ArrayList<Object> list = new ArrayList<Object>();

		list.add("hello");
		list.add(new Integer(2));

		String str = (String) list.get(0);
		Integer in = (Integer) list.get(1);

		System.out.println(str);
		System.out.println(in.intValue());
	}
}

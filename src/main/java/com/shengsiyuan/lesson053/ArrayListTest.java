package com.shengsiyuan.lesson053;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();

		list.add("string");
		list.add(new Integer(2));
		list.add(new Boolean(false));

		String str = (String) list.get(0);
		Integer in = (Integer) list.get(1);
		String b = (String) list.get(2);

	}
}

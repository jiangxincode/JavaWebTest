package com.shengsiyuan.lesson040;

import java.util.ArrayList;

public class ArrayListTest3 {
	public static void main(String[] args) {
		ArrayList<Object> list = new ArrayList<Object>();

		list.add(new Integer(3));
		list.add(new Integer(4));
		list.add(new Integer(5));
		list.add(new Integer(6));

		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			int value = ((Integer) list.get(i)).intValue();

			sum += value;
		}

		System.out.println(sum);
	}
}

package com.shengsiyuan.lesson040;

import java.util.ArrayList;

/**
 * @author zhanglong
 *
 */

public class ArrayListTest5 {
	public static void main(String[] args) {
		ArrayList<Object> list = new ArrayList<Object>();

		list.add(new Point(2, 3));
		list.add(new Point(2, 2));
		list.add(new Point(4, 4));

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println(list);
	}
}

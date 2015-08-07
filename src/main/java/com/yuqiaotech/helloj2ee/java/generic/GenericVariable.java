package com.yuqiaotech.helloj2ee.java.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义了泛型就省去很多类型转换的代码了。
 */
public class GenericVariable {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("abcd");
		list.add("abcde");
		list.add("abcdef");
		List<String> lx = list;

		String s1 = lx.get(0);
		String s2 = (String) list.get(0);

		for (String str : lx) {
			System.out.println("length of [" + str + "] is " + str.length());
		}
		List<String> ly = list;
		for (String l : ly) {
			System.out.println("l=" + l);
		}
	}
}

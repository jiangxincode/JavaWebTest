package com.yuqiaotech.helloj2ee.java.generic;

import java.util.ArrayList;
import java.util.List;
/**
 * 定义了泛型就省去很多类型转换的代码了。
 */
public class GenericVariable {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("abc");
		list.add("abcd");
		list.add("abcde");
		list.add("abcdef");
		List<String> lx = list;
		
		String s1 = lx.get(0);
		String s2 = (String)list.get(0);
		
		for (String str : lx) {
			System.out.println("length of ["+str+"] is "+str.length());
		}
		List<Long> ly = list;
		for (Long l : ly) {
			System.out.println("l="+l);
		}
	}
}

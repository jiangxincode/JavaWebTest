package com.shengsiyuan.lesson048;

import java.util.HashMap;

public class MapTest1 {
	public static void main(String[] args) {
		HashMap<Object,Object> map = new HashMap<Object,Object>();

		map.put("a", "zhangsan");
		map.put("b", "lisi");
		map.put("c", "wangwu");
		map.put("a", "zhaoliu");

		System.out.println(map);
		System.out.println("--------------");

		String value = (String) map.get("b");
		System.out.println(value);
		System.out.println("--------------");

		String value2 = (String) map.get("d");
		System.out.println(value2);

	}
}

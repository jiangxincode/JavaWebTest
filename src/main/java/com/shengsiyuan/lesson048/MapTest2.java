package com.shengsiyuan.lesson048;

import java.util.HashMap;

public class MapTest2 {
	public static void main(String[] args) {
		HashMap<Object,Object> map = new HashMap<Object,Object>();

		String str = new String("zhangsan");

		map.put("a", str);
		map.put("a", str);

		System.out.println(map);
	}
}

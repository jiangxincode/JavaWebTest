package com.shengsiyuan.lesson048;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest3 {
	public static void main(String[] args) {
		HashMap<Object,Object> map = new HashMap<Object,Object>();

		map.put("a", "aa");
		map.put("b", "bb");
		map.put("c", "cc");
		map.put("d", "dd");
		map.put("e", "ee");

		Set<Object> set = map.keySet();

		for (Iterator<Object> iter = set.iterator(); iter.hasNext();) {
			String key = (String) iter.next();
			String value = (String) map.get(key);

			System.out.println(key + "=" + value);
		}
	}
}

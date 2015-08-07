package com.shengsiyuan.lesson049;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest5 {
	public static void main(String[] args) {
		HashMap<Object,Object> map = new HashMap<Object,Object>();

		map.put("a", "aa");
		map.put("b", "bb");
		map.put("c", "cc");
		map.put("d", "dd");

		Set<Entry<Object, Object>> set = map.entrySet();

		for (Iterator<Entry<Object, Object>> iter = set.iterator(); iter.hasNext();) {
			Entry<Object, Object> entry = iter.next();

			String key = (String) entry.getKey();
			String value = (String) entry.getValue();

			System.out.println(key + " : " + value);
		}

	}
}

package com.shengsiyuan.lesson046;

import java.util.HashSet;
import java.util.Iterator;

public class InteratorTest {
	public static void main(String[] args) {
		HashSet<Object> set = new HashSet<Object>();

		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		set.add("e");

		// Iterator iter = set.iterator();
		//
		// while(iter.hasNext())
		// {
		// String value = (String)iter.next();
		// System.out.println(value);
		// }

		for (Iterator<Object> iter = set.iterator(); iter.hasNext();) {
			String value = (String) iter.next();

			System.out.println(value);
		}

	}
}

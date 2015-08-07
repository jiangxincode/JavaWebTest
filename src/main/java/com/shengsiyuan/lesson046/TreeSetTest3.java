package com.shengsiyuan.lesson046;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest3 {
	public static void main(String[] args) {
		TreeSet<Object> set = new TreeSet<Object>(new MyComparator());

		set.add("C");
		set.add("A");
		set.add("B");
		set.add("E");
		set.add("a");
		set.add("F");
		set.add("D");

		for (Iterator<Object> iter = set.iterator(); iter.hasNext();) {
			String value = (String) iter.next();

			System.out.println(value);

		}

	}
}

class MyComparator implements Comparator<Object> {
	public int compare(Object arg0, Object arg1) {
		String s1 = (String) arg0;
		String s2 = (String) arg1;

		return s2.compareTo(s1);
	}
}

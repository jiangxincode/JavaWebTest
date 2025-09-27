package com.shengsiyuan.lesson047;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionsTest {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();

		list.add(new Integer(-8));
		list.add(new Integer(20));
		list.add(new Integer(-20));
		list.add(new Integer(8));

		Comparator<Integer> r = Collections.reverseOrder();

		Collections.sort(list, r);

		for (Iterator<Integer> iter = list.iterator(); iter.hasNext();) {
			System.out.println(iter.next() + " ");
		}

		System.out.println();

		Collections.shuffle(list);

		for (Iterator<Integer> iter = list.iterator(); iter.hasNext();) {
			System.out.println(iter.next() + " ");
		}

		System.out.println("minimum value: " + Collections.min(list));
		System.out.println("maximum value: " + Collections.max(list));
	}
}

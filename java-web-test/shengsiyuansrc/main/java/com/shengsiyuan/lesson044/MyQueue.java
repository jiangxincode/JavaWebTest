package com.shengsiyuan.lesson044;

import java.util.LinkedList;

public class MyQueue {
	private LinkedList<Object> list = new LinkedList<Object>();

	public void put(Object o) {
		list.addLast(o);
	}

	public Object get() {
		return list.removeFirst();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();

		myQueue.put("one");
		myQueue.put("two");
		myQueue.put("three");

		System.out.println(myQueue.get());
		System.out.println(myQueue.get());
		System.out.println(myQueue.get());

		System.out.println(myQueue.isEmpty());

	}

}

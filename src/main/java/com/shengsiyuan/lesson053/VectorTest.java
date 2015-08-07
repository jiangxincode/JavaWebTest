package com.shengsiyuan.lesson053;

import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		Vector<String> vector = new Vector<String>();

		vector.add("hello");
		vector.add("world");
		vector.add("hello world");

		for (int i = 0; i < vector.size(); i++) {
			System.out.println(vector.get(i));
		}
	}
}

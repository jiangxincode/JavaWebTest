package com.shengsiyuan.junit3;

public class MyStack {
	private String[] elements;

	private int nextIndex;

	public MyStack() {
		elements = new String[100];
		nextIndex = 0;
	}

	public void push(String element) throws Exception {
		if (100 == nextIndex) {
			throw new Exception("数组越界异常!");
		}

		elements[nextIndex++] = element;
	}

	public String pop() throws Exception {
		if (0 == nextIndex) {
			throw new Exception("数组越界异常!");
		}

		return elements[--nextIndex];
	}

	public void delete(int n) throws Exception {
		if (nextIndex - n < 0) {
			throw new Exception("数组越界异常!");
		}

		nextIndex -= n;
	}

	public String top() throws Exception {
		if (0 == nextIndex) {
			throw new Exception("数组越界异常!");
		}

		return elements[nextIndex - 1];
	}

}

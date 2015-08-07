package com.shengsiyuan.lesson074.exception;

@SuppressWarnings("serial")
public class MyException extends Exception {
	public MyException() {
		super();
	}

	public MyException(String message) {
		super(message);
	}
}

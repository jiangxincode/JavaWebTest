package com.test.dynamicproxy;

//¾ßÌå½ÇÉ«

public class RealSubject implements Subject {

	public RealSubject() {
	}

	public void request() {
		System.out.println("From real subject.");
	}

}

package com.yuqiaotech.helloj2ee.spring;

public class GreetingServiceImpl implements GreetingService {
	private String greeting;
	private int times;

	public GreetingServiceImpl() {

	}

	public GreetingServiceImpl(String greeting) {
		this.greeting = greeting;
	}

	public void sayGreeting() {
		times++;
		System.out.println("^^^^^^^^^^" + greeting + " & times=" + times);
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
}
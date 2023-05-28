package com.yuqiaotech.helloj2ee.spring;

public class GreetingServiceImpl2 implements GreetingService {
	private String who;

	public void sayGreeting() {
		if ("Jack".equals(who))
			throw new RuntimeException("never say hello to Jack!");
		System.out.println("你好: " + who);
	}

	public void setGreetingTo(String who) {
		this.who = who;
	}
}
package com.yuqiaotech.helloj2ee.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) throws Exception {
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		GreetingService greetingService = (GreetingService) factory.getBean("greetingService");
		System.out.println("HelloSpring.main()[[[[" + greetingService.getClass().getName() + "]]]]");
		System.out.println("-----------");
		greetingService.sayGreeting();
		System.out.println("-----------");

		// GreetingServiceImpl greetingServicex = new GreetingServiceImpl();
		// greetingServicex.setGreeting("hello Tom");
		//
		// greetingServicex.sayGreeting();
	}
}
package com.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Client {
	public static void main(String[] args) {
		ClassPathResource cpr = new ClassPathResource("applicationContext.xml");

		XmlBeanFactory factory = new XmlBeanFactory(cpr);

		Person p = (Person) factory.getBean("chinese");

		p.work();

		// Chinese chinese = new Chinese();
		//
		// Tool tool = new ConcreteToolB();
		//
		// chinese.setTool(tool);
		//
		// chinese.work();
	}
}

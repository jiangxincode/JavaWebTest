package com.test.simplefactory;

public class Client {

	public static void main(String[] args) {
		
		PersonFactory pf = new PersonFactory();
		Person p = null;

		p = pf.getPerson("chinese");
		System.out.println(p.sayHello("����"));
		System.out.println(p.sayGoodBye("����"));

		p = pf.getPerson("american");
		System.out.println(p.sayHello("Tom"));
		System.out.println(p.sayGoodBye("Tom"));
		
		
/*
		Person chinese = new Chinese();

		System.out.println(chinese.sayHello("����"));
		System.out.println(chinese.sayGoodBye("����"));

		Person american = new American();

		System.out.println(american.sayHello("Tom"));
		System.out.println(american.sayGoodBye("Tom"));
*/
	}
}

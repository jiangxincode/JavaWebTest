package com.test.observer;

public class Client {
	public static void main(String[] args) {
		ConcreteSubject subject = new ConcreteSubject();

		ConcreteObserver o1 = new ConcreteObserver();
		ConcreteObserver o2 = new ConcreteObserver();
		ConcreteObserver o3 = new ConcreteObserver();

		subject.attach(o1);
		subject.attach(o2);
		subject.attach(o3);

		subject.a();

		subject.detach(o1);

		System.out.println();

		subject.a();

	}
}

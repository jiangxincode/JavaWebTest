package com.shengsiyuan.lesson011;

public class ParamTest {
	public static void main(String[] args) {
		Person person = new Person();

		person.change(person);

		int age = person.age;

		System.out.println(age);

		System.out.println("--------------------------");

		int i = 10;

		person.change2(i);

		System.out.println(i);
	}
}

class Person {
	int age = 20;

	public void change(Person person) {
		person = new Person();

		person.age = 30;
	}

	public void change2(int age) {
		age = 40;
	}
}

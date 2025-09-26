package com.shengsiyuan.lesson011;

/**
 * 此处所有的Person全部改为Persons，防止和该包下的ParamTest.java中的Person类冲突
 * 
 * @author Administrator
 *
 */
public class PersonTest {
	public static void main(String[] args) {
		Person1 person = new Person1(50);

		System.out.println(person.age);
	}
}

class Person1 {
	int age;

	public Person1(int i) {
		age = i;
	}
}

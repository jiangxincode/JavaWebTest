package com.shengsiyuan.lesson011;

/**
 * �˴����е�Personȫ����ΪPersons����ֹ�͸ð��µ�ParamTest.java�е�Person���ͻ
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

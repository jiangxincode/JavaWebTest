package com.shengsiyuan.lesson027;

public class InstanceofTest {
	public static void main(String[] args) {
		People people = new Man();

		System.out.println(people instanceof People);
		System.out.println(people instanceof Man);
	}
}

class People {

}

class Man extends People {

}

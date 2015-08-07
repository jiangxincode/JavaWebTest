package com.shengsiyuan.lesson017;

public class Child extends Parent {
	public Child() {

		super(1);
		System.out.println("child");
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Child child = new Child();
	}
}

class Parent {
	public Parent(int i) {
		System.out.println("parent");
	}

	public Parent() {
		System.out.println("no args parent");
	}

}

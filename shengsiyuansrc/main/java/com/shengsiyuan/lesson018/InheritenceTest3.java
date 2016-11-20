package com.shengsiyuan.lesson018;

public class InheritenceTest3 {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Son son = new Son();
	}
}

class Grandpa {
	public Grandpa() {
		System.out.println("grandpa");
	}
}

class Father extends Grandpa {
	public Father() {
		System.out.println("father");
	}
}

class Son extends Father {
	public Son() {
		System.out.println("son");
	}
}

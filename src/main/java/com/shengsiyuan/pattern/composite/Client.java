package com.shengsiyuan.pattern.composite;

public class Client {
	public static void main(String[] args) {
		Component leaf1 = new Leaf();
		Component leaf2 = new Leaf();

		Composite comp1 = new Composite();

		comp1.add(leaf1);
		comp1.add(leaf2);

		Component leaf3 = new Leaf();
		Component leaf4 = new Leaf();

		Composite comp2 = new Composite();

		comp2.add(comp1);
		comp2.add(leaf3);
		comp2.add(leaf4);

		comp2.doSomething();
	}
}

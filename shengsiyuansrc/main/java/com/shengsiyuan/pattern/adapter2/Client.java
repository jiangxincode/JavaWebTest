package com.shengsiyuan.pattern.adapter2;

public class Client {
	public static void main(String[] args) {
		Target target = new Adapter(new Adaptee());

		target.method1();
	}
}

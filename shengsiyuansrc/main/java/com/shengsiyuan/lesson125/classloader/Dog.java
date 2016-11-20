package com.shengsiyuan.lesson125.classloader;

public class Dog {
	public Dog() {
		System.out.println("Dog is loaded by : "
				+ this.getClass().getClassLoader());
	}
}

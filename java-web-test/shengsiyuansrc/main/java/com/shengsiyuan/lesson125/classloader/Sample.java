package com.shengsiyuan.lesson125.classloader;

public class Sample {
	public int v1 = 1;

	public Sample() {
		System.out.println("Sample is loaded by: "
				+ this.getClass().getClassLoader());

		new Dog();
	}
}

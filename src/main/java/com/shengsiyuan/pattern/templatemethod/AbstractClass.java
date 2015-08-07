package com.shengsiyuan.pattern.templatemethod;

public abstract class AbstractClass {
	public void template() {
		this.method1();
		this.method2();
		this.method3();
	}

	public abstract void method1();

	public abstract void method2();

	public abstract void method3();

}

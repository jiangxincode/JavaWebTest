package com.shengsiyuan.lesson093.decorator;

public class ConcreteComponent implements Component {
	@Override
	public void doSomething() {
		System.out.println("功能A");
	}

}

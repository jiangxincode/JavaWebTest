package com.shengsiyuan.pattern.composite;

public class Leaf implements Component {
	@Override
	public void doSomething() {
		System.out.println("执行方法");
	}

}

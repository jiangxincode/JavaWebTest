﻿package com.shengsiyuan.pattern.defaultadapter;

public class ConcreteService extends ServiceAdapter {
	@Override
	public void service1() {
		System.out.println("执行业务方法");
	}
}

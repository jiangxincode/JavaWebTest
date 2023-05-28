package com.shengsiyuan.lesson070.annotation;


@MyAnnotation(hello = "beijing", world = "shanghai")
public class MyTest {
	@MyAnnotation(hello = "tianjin", world = "shangdi")
	@Deprecated
	// @SuppressWarnings("unchecked") //一个方法可以由多个注解修
	public void output() {
		System.out.println("output something!");
	}
}

package com.shengsiyuan.lesson071.annotation;

public class DocumentedTest {
	@DocumentedAnnotation(hello = "welcome")
	public void method() {
		System.out.println("hello world");
	}
}

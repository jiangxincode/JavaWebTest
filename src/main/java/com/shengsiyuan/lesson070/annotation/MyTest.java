package com.shengsiyuan.lesson070.annotation;


@MyAnnotation(hello = "beijing", world = "shanghai")
public class MyTest {
	@MyAnnotation(hello = "tianjin", world = "shangdi")
	@Deprecated
	// @SuppressWarnings("unchecked") //һ�����������ɶ��ע����
	public void output() {
		System.out.println("output something!");
	}
}

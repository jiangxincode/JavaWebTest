package com.yuqiaotech.helloj2ee.java.generic;

public class GenericMethod {

	protected Object foo;

	@SuppressWarnings("unchecked")
	public <T> T getFoo() {
		return (T) foo;
	}

	public <T> void setFoo(T foo) {
		this.foo = foo;
	}

	public static void main(String[] args) {
		GenericMethod c = new GenericMethod();
		String str = "abc";
		c.<String> setFoo(str);
		@SuppressWarnings("unused")
		String strx = c.<String> getFoo();
		System.out.println("foo1=" + c.getFoo());
		System.out.println("-----------------------");

		GenericMethod cx = new GenericMethod();
		Long l = 123l;
		cx.setFoo(l);
		System.out.println("foo2=" + cx.getFoo());
		System.out.println("-----------------------");
	}
}

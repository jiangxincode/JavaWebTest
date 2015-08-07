package com.yuqiaotech.helloj2ee.java.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class GenericClass<T> {

	protected T foo;

	public T getFoo() {
		return foo;
	}

	public void setFoo(T foo) {
		this.foo = foo;
	}

	public void genericInfo() {
		Type genericSuperclass = getClass().getGenericSuperclass();
		TypeVariable<?>[] vars = getClass().getSuperclass().getTypeParameters();
		System.out.println("TypeParameter=" + vars[0]);
		Class<?> typeOfT = (Class<?>) ((ParameterizedType) genericSuperclass)
				.getActualTypeArguments()[0];
		System.out.println("type of T=" + typeOfT.getName());
	}

	static class SubGenericClass extends GenericClass<Integer> {

	}

	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		GenericClass<String> c = new GenericClass<String>();
		String str = "abc";
		c.setFoo(str);
		String s = c.getFoo();
		System.out.println("foo1=" + c.getFoo());
		System.out.println("-----------------------");

		GenericClass<Long> cx = new GenericClass<Long>();
		Long l = 123l;
		cx.setFoo(l);
		System.out.println("foo2=" + cx.getFoo());
		System.out.println("-----------------------");
		
		// 下面的代码合理吗？运行一下看看。然后理解一下所谓类型擦除
		GenericClass cxx = new GenericClass<Long>();
		cxx.setFoo(str);
		System.out.println("foo3=" + cxx.getFoo());
		System.out.println("-----------------------");
		
		// 简单了解一下
		SubGenericClass sc = new SubGenericClass();
		sc.genericInfo();
		System.out.println("-----------------------");
	}
}

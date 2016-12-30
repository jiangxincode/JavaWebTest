package com.shengsiyuan.ognl;

import java.util.ArrayList;
import java.util.List;

import ognl.Ognl;
import ognl.OgnlContext;

public class OgnlTest {
	public static void main(String[] args) throws Exception {
		Person person = new Person();
		person.setName("zhangsan");

		Dog dog2 = new Dog();
		dog2.setName("hello");

		person.setDog(dog2);

		Dog dog = new Dog();
		dog.setName("wangcai");

		OgnlContext context = new OgnlContext();

		context.put("person", person);
		context.put("dog", dog);

		context.setRoot(person); // 根对象

		Object object = Ognl.parseExpression("#person.dog.name");

		System.out.println(object);

		Object object2 = Ognl.getValue(object, context, context.getRoot());

		System.out.println(object2);

		System.out.println("----------------------------");

		Object object3 = Ognl.parseExpression("#person.name");

		System.out.println(object3);

		Object object4 = Ognl.getValue(object3, context, context.getRoot());

		System.out.println(object4);

		System.out.println("----------------------------");

		Object object5 = Ognl.parseExpression("#dog.name");

		System.out.println(object5);

		Object object6 = Ognl.getValue(object5, context, context.getRoot());

		System.out.println(object6);

		System.out.println("----------------------------");

		Object object7 = Ognl.parseExpression("name.toUpperCase().length()");

		System.out.println(object7);

		Object object8 = Ognl.getValue(object7, context, context.getRoot());

		System.out.println(object8);

		System.out.println("----------------------------");

		Object object9 = Ognl.parseExpression("@java.lang.Integer@toBinaryString(10)");

		System.out.println(object9);

		Object object10 = Ognl.getValue(object9, context, context.getRoot());

		System.out.println(object10);

		System.out.println("----------------------------");

		Object object11 = Ognl.parseExpression("@@min(4, 10)");

		System.out.println(object11);

		Object object12 = Ognl.getValue(object11, context, context.getRoot());

		System.out.println(object12);

		System.out.println("----------------------------");

		Object object13 = Ognl.parseExpression("new java.util.LinkedList()");

		System.out.println(object13);

		Object object14 = Ognl.getValue(object13, context, context.getRoot());

		System.out.println(object14);

		System.out.println("----------------------------");

		Object object15 = Ognl.getValue("{'aa', 'bb', 'cc', 'dd'}[2]", context, context.getRoot());

		System.out.println(object15);

		System.out.println("----------------------------");

		dog.setFriends(new String[] { "aa", "bb", "cc" });

		Object object16 = Ognl.getValue("#dog.friends[1]", context, context.getRoot());

		System.out.println(object16);

		System.out.println("----------------------------");

		List<String> list = new ArrayList<String>();

		list.add("hello");
		list.add("world");
		list.add("hello world");

		context.put("list", list);

		System.out.println(Ognl.getValue("#list[0]", context, context.getRoot()));

		System.out.println("----------------------------");

		System.out.println(
				Ognl.getValue("#{'key1': 'value1', 'key2': 'value2', 'key3': 'value3', 'key4': 'value4'}['key3']",
						context, context.getRoot()));

		System.out.println("----------------------------");

		List<Person> persons = new ArrayList<Person>();

		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();

		p1.setName("zhangsan");
		p2.setName("lisi");
		p3.setName("wangwu");

		persons.add(p1);
		persons.add(p2);
		persons.add(p3);

		context.put("persons", persons);

		// 过滤（filtering）,collection.{? expression}

		System.out.println(Ognl.getValue("#persons.{? #this.name.length() > 4}[0].name", context, context.getRoot()));

		// 过滤（filtering）,获取到集合中的第一个元素, collection.{^ expression}

		System.out.println(Ognl.getValue("#persons.{^ #this.name.length() > 4}[0].name", context, context.getRoot()));

		// 过滤（filtering）,获取到集合中的第一个元素, collection.{$ expression}

		System.out.println(Ognl.getValue("#persons.{$ #this.name.length() > 4}[0].name", context, context.getRoot()));

		System.out.println("----------------------------");

		// 投影（projection）, collection. {expression}

		System.out.println(Ognl.getValue("#persons.{name}", context, context.getRoot()));

		System.out.println("----------------------------");

		System.out.println(Ognl.getValue("#persons.{#this.name.length() <= 5 ? 'Hello World' : #this.name}", context,
				context.getRoot()));

	}
}

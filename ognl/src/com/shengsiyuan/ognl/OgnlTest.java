package com.shengsiyuan.ognl;

import ognl.Ognl;
import ognl.OgnlContext;

public class OgnlTest
{
	public static void main(String[] args) throws Exception
	{
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
		
		context.setRoot(person);
		
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

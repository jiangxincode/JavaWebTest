package com.shengsiyuan.json;

import java.util.ArrayList;

import com.google.gson.Gson;

public class Test2
{
	public static void main(String[] args)
	{
		Person person = new Person();
		
		person.setUsername("zhangsan");
		person.setPassword("123456");
		person.setAddress("beijing");
		person.setAge(30);
		
		person.getList().add("hello");
		person.getList().add("world");
		person.getList().add("hello world");
		
		Gson gson = new Gson();
		
		String result = gson.toJson(person);
		
		System.out.println(result);
	}
}

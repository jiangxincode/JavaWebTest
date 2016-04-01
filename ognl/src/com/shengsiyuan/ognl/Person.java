package com.shengsiyuan.ognl;

public class Person
{
	private String name;
	
	private Dog dog;
	
	public Dog getDog()
	{
		return dog;
	}

	public void setDog(Dog dog)
	{
		this.dog = dog;
	}

	public String getName()
	{
		System.out.println("getName invoked!");
		
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}

package com.shengsiyuan.hibernate;

import java.util.Set;

public class Student
{
	private String id;
	
	private String cardId;
	
	private int age;
	
	private String name;
	
	private Set<Course> courses;

	public Student()
	{
		
	}

	public Student(String name, int age)
	{
		this.age = age;
		this.name = name;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Set<Course> getCourses()
	{
		return courses;
	}

	public void setCourses(Set<Course> courses)
	{
		this.courses = courses;
	}

	public String getCardId()
	{
		return cardId;
	}

	public void setCardId(String cardId)
	{
		this.cardId = cardId;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
}

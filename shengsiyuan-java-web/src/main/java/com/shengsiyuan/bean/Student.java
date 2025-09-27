package com.shengsiyuan.bean;

public class Student
{
	private long classNo;

	private String name;

	private int age;

	private boolean sexy;

	public Student()
	{ 
		classNo = 970431;
		name = "ZZZl";
		age = 34;
		sexy = true;
	}

	public long getClassNo()
	{
		return classNo;
	}

	public void setClassNo(long classNo)
	{
		this.classNo = classNo;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public boolean isSexy()
	{
		return sexy;
	}

	public void setSexy(boolean sexy)
	{
		this.sexy = sexy;
	}

}

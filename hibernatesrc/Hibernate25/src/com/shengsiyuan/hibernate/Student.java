package com.shengsiyuan.hibernate;

import java.util.Date;

public class Student
{
	private String id;
	
	private String cardId;
	
	private int age;
	
	private String name;
	
	private Date lastDate;
	
	public Student()
	{
		
	}

	public Student(String name, int age)
	{
		this.age = age;
		this.name = name;
	}
	
	public Date getLastDate()
	{
		return lastDate;
	}

	public void setLastDate(Date lastDate)
	{
		this.lastDate = lastDate;
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

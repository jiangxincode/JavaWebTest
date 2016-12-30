package com.shengsiyuan.hibernate;

public class Student
{
	private String id;
	
	private String name;
	
	private IdCard idCard;

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

	public IdCard getIdCard()
	{
		return idCard;
	}

	public void setIdCard(IdCard idCard)
	{
		this.idCard = idCard;
	}
}

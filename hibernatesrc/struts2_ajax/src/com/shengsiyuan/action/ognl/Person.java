package com.shengsiyuan.action.ognl;

import java.util.Map;

public class Person
{
	private String name;

	private int age;

	private String address;

	private String[] friends;

	private Cat cat;

	private Map<String, String> map;

	public Person(String name, int age, String address, String[] friends,
			Cat cat, Map<String, String> map)
	{
		this.name = name;
		this.age = age;
		this.address = address;
		this.friends = friends;
		this.cat = cat;
		this.map = map;
	}

	public Person()
	{
		
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

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String[] getFriends()
	{
		return friends;
	}

	public void setFriends(String[] friends)
	{
		this.friends = friends;
	}

	public Cat getCat()
	{
		return cat;
	}

	public void setCat(Cat cat)
	{
		this.cat = cat;
	}

	public Map<String, String> getMap()
	{
		return map;
	}

	public void setMap(Map<String, String> map)
	{
		this.map = map;
	}

}

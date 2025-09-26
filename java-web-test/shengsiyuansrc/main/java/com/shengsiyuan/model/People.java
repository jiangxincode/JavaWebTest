package com.shengsiyuan.model;

import java.util.List;

public class People
{
	private int id;
	
	private String name;
	
	private Address address;
	
	private List<People> friends;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
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

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public List<People> getFriends()
	{
		return friends;
	}

	public void setFriends(List<People> friends)
	{
		this.friends = friends;
	}
}

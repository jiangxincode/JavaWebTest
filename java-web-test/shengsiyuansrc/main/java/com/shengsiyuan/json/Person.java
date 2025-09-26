package com.shengsiyuan.json;

import java.util.ArrayList;
import java.util.List;

public class Person
{
	private String username;
	
	private String password;
	
	private int age;
	
	private String address;
	
	private List<String> list = new ArrayList<String>();
	
	public List<String> getList()
	{
		return list;
	}

	public void setList(List<String> list)
	{
		this.list = list;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
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
}

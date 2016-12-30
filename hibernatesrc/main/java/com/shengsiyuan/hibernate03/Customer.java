package com.shengsiyuan.hibernate03;

import java.util.Set;

public class Customer
{
	private Long id;

	private String name;

	private Set orders; //一对多，通过该变量可以引用到对应的Order集合对象

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
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

	public Set getOrders()
	{
		return orders;
	}

	public void setOrders(Set orders)
	{
		this.orders = orders;
	}


}

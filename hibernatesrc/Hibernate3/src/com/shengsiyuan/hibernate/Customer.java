package com.shengsiyuan.hibernate;

import java.util.Set;

public class Customer
{
	private Long id;
	
	private String name;
	
	private Set orders; //һ�Զ࣬ͨ���ñ����������õ���Ӧ��Order���϶���

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

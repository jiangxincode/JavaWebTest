package com.shengsiyuan.hibernate03;

public class Order
{
	private Long id;

	private String orderNumber;

	private Customer customer;  //多对一，通过该变量可以引用到关联的Customer对象

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getOrderNumber()
	{
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber)
	{
		this.orderNumber = orderNumber;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
}

package com.shengsiyuan.hibernate;

public class Teacher extends Person
{
	private int salary;

	public int getSalary()
	{
		return salary;
	}

	public void setSalary(int salary)
	{
		this.salary = salary;
	}
}

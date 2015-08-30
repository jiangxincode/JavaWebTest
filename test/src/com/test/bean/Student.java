package com.test.bean;

public class Student
{
	private long classNo;

	private String name; 

	private int age;

	private boolean sexy;

	public Student() // 构造函数
	{
		classNo = 970431;
		name = "ZZZl";
		age = 34;
		sexy = true;
	}

	/**
	 * @return 返回 age。
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * @param age
	 *            要设置的 age。
	 */
	public void setAge(int age)
	{
		this.age = age;
	}

	/**
	 * @return 返回 classNo。
	 */
	public long getClassNo()
	{
		return classNo;
	}

	/**
	 * @param classNo
	 *            要设置的 classNo。
	 */
	public void setClassNo(long classNo)
	{
		this.classNo = classNo;
	}

	/**
	 * @return 返回 name。
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            要设置的 name。
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return 返回 sexy。
	 */
	public boolean isSexy()
	{
		return sexy;
	}

	/**
	 * @param sexy
	 *            要设置的 sexy。
	 */
	public void setSexy(boolean sexy)
	{
		this.sexy = sexy;
	}
}
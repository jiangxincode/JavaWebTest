package com.test.bean;

public class Student
{
	private long classNo;

	private String name; 

	private int age;

	private boolean sexy;

	public Student() // ���캯��
	{
		classNo = 970431;
		name = "ZZZl";
		age = 34;
		sexy = true;
	}

	/**
	 * @return ���� age��
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * @param age
	 *            Ҫ���õ� age��
	 */
	public void setAge(int age)
	{
		this.age = age;
	}

	/**
	 * @return ���� classNo��
	 */
	public long getClassNo()
	{
		return classNo;
	}

	/**
	 * @param classNo
	 *            Ҫ���õ� classNo��
	 */
	public void setClassNo(long classNo)
	{
		this.classNo = classNo;
	}

	/**
	 * @return ���� name��
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            Ҫ���õ� name��
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return ���� sexy��
	 */
	public boolean isSexy()
	{
		return sexy;
	}

	/**
	 * @param sexy
	 *            Ҫ���õ� sexy��
	 */
	public void setSexy(boolean sexy)
	{
		this.sexy = sexy;
	}
}
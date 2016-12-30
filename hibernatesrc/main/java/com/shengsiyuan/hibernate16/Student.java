package com.shengsiyuan.hibernate16;

public class Student
{
	private StudentPrimaryKey studentPrimaryKey;

	private int age;

	public StudentPrimaryKey getStudentPrimaryKey()
	{
		return studentPrimaryKey;
	}

	public void setStudentPrimaryKey(StudentPrimaryKey studentPrimaryKey)
	{
		this.studentPrimaryKey = studentPrimaryKey;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
}

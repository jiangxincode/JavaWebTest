package com.shengsiyuan.hibernate;

import java.util.ArrayList;
import java.util.List;

public class Team
{
	private String id;
	
	private String teamName;
	
	private List students = new ArrayList(); // Hibernate使用List来模拟Bag

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getTeamName()
	{
		return teamName;
	}

	public void setTeamName(String teamName)
	{
		this.teamName = teamName;
	}

	public List getStudents()
	{
		return students;
	}

	public void setStudents(List students)
	{
		this.students = students;
	}
}

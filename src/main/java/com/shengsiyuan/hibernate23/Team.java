package com.shengsiyuan.hibernate23;

import java.util.HashSet;
import java.util.Set;

public class Team
{
	private String id;

	private String teamName;

	private Set students = new HashSet();

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

	public Set getStudents()
	{
		return students;
	}

	public void setStudents(Set students)
	{
		this.students = students;
	}
}

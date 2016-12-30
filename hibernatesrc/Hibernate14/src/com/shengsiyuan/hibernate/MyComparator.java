package com.shengsiyuan.hibernate;

import java.util.Comparator;

public class MyComparator implements Comparator<Student>
{
	@Override
	public int compare(Student o1, Student o2)
	{
		if(o1 == o2)
		{
			return 0;
		}
		
		int result = o1.getCardId().compareTo(o2.getCardId());
		
		if(result != 0)
		{
			return -result;
		}
		
		return -o1.getName().compareTo(o2.getName());
	}
}

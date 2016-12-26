package com.shengsiyuan.hibernate;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTest
{
	private static SessionFactory sessionFactory;

	static
	{
		try
		{
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			
//			Student student = new Student();
//			
//			student.setName("zhangsan");
//			student.setCardId("123456");
//			student.setAge(30);
//			
//			session.save(student);
			
			
			Student studentPrimaryKey = new Student();
			
			studentPrimaryKey.setCardId("123456");
			studentPrimaryKey.setName("zhangsan");
			
			Student student = (Student)session.get(Student.class, studentPrimaryKey);
			
			System.out.println(student.getAge());
			System.out.println(studentPrimaryKey.getAge());
			
			tx.commit(); 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
			if(null != tx)
			{
				tx.rollback();
			}
		}
		finally
		{
			session.close();
		}
		
	
		
		
		
		
		
		
		
		
		
		
		
	}
}

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
//			Address address = new Address();
//			
//			address.setHomeAddress("beijing");
//			address.setSchoolAddress("shanghai");
//			
//			student.setName("zhangsan");
//			
//			student.setAddress(address);
//			
//			session.saveOrUpdate(student);
			
			Student student = (Student)session.get(Student.class, "402881ec2ec6e8b7012ec6e8b8f30001");
			
			System.out.println(student.getName());
			System.out.println(student.getAddress().getHomeAddress());
			System.out.println(student.getAddress().getSchoolAddress());
			
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

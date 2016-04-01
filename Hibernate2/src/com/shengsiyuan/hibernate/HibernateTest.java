package com.shengsiyuan.hibernate;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;

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
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		People people = new People();
		
		people.setUsername("zhangsan");
		people.setPassword("123456");
		people.setGender('F');
		java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
		System.out.println(date);
		people.setBirthday(date);
		people.setGraduation(false);
		people.setTelphone(987654);
		people.setMarryTime(new Timestamp(new java.util.Date().getTime()));
		
		InputStream is = new FileInputStream("c:/Hibernate_1.pdf");
		
		int length = is.available();
		
		byte[] buffer = new byte[length];
		
		is.read(buffer);
		
		people.setFile(buffer);
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			
			session.save(people);
			
			tx.commit();
		}
		catch(Exception ex)
		{
			if(null != tx)
			{
				tx.rollback();
			}
			
			ex.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

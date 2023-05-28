package com.shengsiyuan.hibernate02.hibernate;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shengsiyuan.hibernate02.interceptor.TestInterceptor;

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
		people.setBirthday(date);
		people.setGraduation(false);
		people.setTelphone(987654);
		people.setMarryTime(new Timestamp(new java.util.Date().getTime()));

		InputStream is = new FileInputStream("c:/RandomTest.class");

		int length = is.available();

		byte[] buffer = new byte[length];

		is.read(buffer);

		people.setFile(buffer);

		Session session = sessionFactory.openSession(new TestInterceptor());
		Transaction tx = null;

		try
		{
			tx = session.beginTransaction();

//			session.save(people);

			People p = (People)session.get(People.class, new Long(1));

			System.out.println(p.getUsername());

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



		/*

		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try
		{
			tx = session.beginTransaction();

			Query query = session.createQuery("from People as p order by p.id asc").setFirstResult(1).setMaxResults(20);

			List<People> list = (List<People>)query.list();

			for(Iterator<People> iter = list.iterator(); iter.hasNext();)
			{
				People people = iter.next();

				System.out.println(people.getUsername());
				System.out.println(people.getPassword());
				System.out.println(people.getTelphone());
				System.out.println(people.getBirthday());
				System.out.println(people.getId());
				System.out.println(people.getMarryTime());
				System.out.println(people.getGender());
				System.out.println(people.isGraduation());

				System.out.println("-----------------------");

				byte[] buffer = people.getFile();

				OutputStream os = new FileOutputStream("C:/" + people.getId() + ".pdf");
				os.write(buffer);
				os.close();
			}
		}
		catch(Exception ex)
		{
			if(null != tx)
			{
				tx.rollback();
			}
		}
		finally
		{
			session.close();
		}

		*/

		/*

		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try
		{
			tx = session.beginTransaction();

			People people = (People)session.load(People.class, new Long(1));

			people.setUsername("lisi");
			people.setGender('M');

			people.setUsername("wangwu");
			people.setGender('F');

			people.setUsername("zhangsan");

			//session.update(people);

			tx.commit();
		}
		catch(Exception ex)
		{
			if(null != tx)
			{
				tx.rollback();
			}
		}
		finally
		{
			session.close();
		}

		*/


//		Session session = sessionFactory.openSession();
//		Transaction tx = null;

//		List<People> list = null;
//
//		Iterator<People> iter = null;

//		try
//		{
//			tx = session.beginTransaction();

			/*
			Query query = session.createQuery("from People");

			Iterator<People> iter = (Iterator<People>)query.iterate();

			while(iter.hasNext())
			{
				session.delete(iter.next());
			}
			*/

//			Query query = session.createQuery("from People");
//
//			iter = (Iterator<People>)query.iterate();

			//list = (List<People>)query.list();

//			for(Iterator<People> iter = list.iterator(); iter.hasNext();)
//			{
//				session.delete(iter.next());
//			}

//			tx.commit();
//		}
//		catch(Exception ex)
//		{
//			if(null != tx)
//			{
//				tx.rollback();
//			}
//		}
//		finally
//		{
//			session.close();
//		}
//
//		while(iter.hasNext())
//		{
//			System.out.println(iter.next().getId());
//		}
	}
}

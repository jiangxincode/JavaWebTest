package com.shengsiyuan.hibernate22;

import java.util.List;

import org.hibernate.Query;
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
		Query query = null;
		List list = null;

		try
		{
			tx = session.beginTransaction();

//			Query query = session.createQuery("select s.name, s.age from Student s");
//
//			List list = query.list();
//
//			for(int i = 0; i < list.size(); i++)
//			{
//				Object[] obj = (Object[])list.get(i);
//
//				System.out.println(obj[0] + ", " + obj[1]);
//			}

//			Query query = session.createQuery("select new Student(s.name, s.age) from Student s");
//
//			List list = query.list();
//
//			for(int i = 0; i < list.size(); i++)
//			{
//				Student student = (Student)list.get(i);
//
//				System.out.println(student.getName() + ", " + student.getAge());
//
//				System.out.println(student.getCardId());
//			}

			query = session.createQuery("from Team t join t.students");

			list = query.list();

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

		for(int i = 0; i < list.size(); i++)
		{
			Object[] obj = (Object[]) list.get(i);

			Team team = (Team)obj[0];
			Student student = (Student)obj[1];

			System.out.println(team.getTeamName());
			System.out.println(student.getName());

			System.out.println("----------");
		}
	}
}

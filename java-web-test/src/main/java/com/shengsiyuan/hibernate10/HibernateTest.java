package com.shengsiyuan.hibernate10;

import java.util.Map;

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

			Team team = new Team();
			team.setTeamName("team1");

			Team team2 = new Team();
			team2.setTeamName("team2");

			Student s1 = new Student();
			Student s2 = new Student();
			Student s3 = new Student();
			Student s4 = new Student();
			Student s5 = new Student();
			Student s6 = new Student();

			s1.setName("zhangsan");
			s2.setName("lisi");
			s3.setName("wangwu");
			s4.setName("zhaoliu");
			s5.setName("hello");
			s6.setName("world");

			team.getStudents().add(s1);
			team.getStudents().add(s2);

			team2.getStudents().add(s3);
			team2.getStudents().add(s4);
			team2.getStudents().add(s5);
			team2.getStudents().add(s6);

			session.save(team);
			session.save(team2);

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

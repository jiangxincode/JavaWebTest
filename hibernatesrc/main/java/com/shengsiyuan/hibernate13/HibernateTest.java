package com.shengsiyuan.hibernate13;

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

//			Team team = new Team();
//			team.setTeamName("team1");
//
//			team.getStudents().add("zhangsan");
//			team.getStudents().add("lisi");
//			team.getStudents().add("wangwu");
//
//			session.save(team);

			Team team = (Team)session.get(Team.class, "402881ec2ec1f120012ec1f122c40001");

			Set set = team.getStudents();

			Iterator iter = set.iterator();

			while(iter.hasNext())
			{
				System.out.println(iter.next());
			}

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

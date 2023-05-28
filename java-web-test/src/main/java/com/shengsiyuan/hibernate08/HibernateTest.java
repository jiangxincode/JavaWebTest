package com.shengsiyuan.hibernate08;

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

			Map map = team.getStudents();

			Student student1 = new Student();
			student1.setAge(20);
			student1.setName("zhangsan");
			//student1.setCardId("111");
			student1.setTeam(team);

			Student student2 = new Student();
			student2.setAge(20);
			student2.setName("zhangsan");
			//student2.setCardId("222");
			student2.setTeam(team);

			Student student3 = new Student();
			student3.setAge(20);
			student3.setName("zhangsan");
			//student3.setCardId("333");
			student3.setTeam(team);

			map.put("aaa", student1);
			map.put("bbb", student2);
			map.put("ccc", student3);

			session.save(team);

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

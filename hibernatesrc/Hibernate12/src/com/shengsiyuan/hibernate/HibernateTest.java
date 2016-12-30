package com.shengsiyuan.hibernate;

import java.util.Collection;
import java.util.Iterator;
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
			
//			Team team = new Team();
//			team.setTeamName("team1");
//			
//			Map map = team.getStudents();
//			
//			map.put("zhangsan", "helloworld");
//			map.put("lisi", "welcome");
//			map.put("wangwu","haha");
//			map.put("zhaoliu", "test123");
//			
//			session.save(team);
			
			Team team = (Team)session.createQuery("from Team t where t.teamName = 'team1'").uniqueResult();
			
			Map map = team.getStudents();
			
			Collection col = map.values();
			
			Iterator iter = col.iterator();
			
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

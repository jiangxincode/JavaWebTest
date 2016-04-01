package com.shengsiyuan.hibernate;

import java.util.List;

import org.hibernate.Hibernate;
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
		
		try
		{
			tx = session.beginTransaction();
			
			Team team = (Team)session.get(Team.class, "ff80808105416d3b0105416d3eca0002");
			
			//Query query = session.createQuery("from Student s where s.team = :team and s.age > 20");
			
			//query.setParameter("team", team, Hibernate.entity(Team.class));
			
			//query.setEntity("team", team);
			
			Query query = session.createFilter(team.getStudents(), "where age > 20");
			
			List<Student> list = query.list();
			
			System.out.println(list.size());
			
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

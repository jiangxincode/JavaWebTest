package com.shengsiyuan.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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

			// Criteria criteria = session.createCriteria(Student.class).add(
			// Restrictions.between("age", new Integer(12),
			// new Integer(30)));

			// Criteria criteria = session.createCriteria(Student.class).add(
			// Restrictions.like("name", "t%"));

			// String[] names = { "jerry", "spark", "tom" };
			//
			// Criteria criteria = session.createCriteria(Student.class).add(
			// Restrictions.in("name", names));

			Criteria criteria = session.createCriteria(Student.class).addOrder(
					Order.asc("age")).addOrder(Order.desc("cardId"));

			List<Student> list = criteria.list();

			for (Student student : list)
			{
				System.out.println(student.getName());
			}

			tx.commit();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();

			if (null != tx)
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

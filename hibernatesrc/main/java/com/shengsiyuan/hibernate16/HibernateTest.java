package com.shengsiyuan.hibernate16;

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

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try
		{
			tx = session.beginTransaction();

//			StudentPrimaryKey studentPrimaryKey = new StudentPrimaryKey();
//			studentPrimaryKey.setCardId("123456");
//			studentPrimaryKey.setName("lisi");
//
//			Student student = new Student();
//			student.setAge(30);
//			student.setStudentPrimaryKey(studentPrimaryKey);
//
//			session.save(student);


			StudentPrimaryKey studentPrimaryKey = new StudentPrimaryKey();

			studentPrimaryKey.setCardId("123456");
			studentPrimaryKey.setName("lisi");

			Student student = (Student)session.get(Student.class, studentPrimaryKey);

			System.out.println(student.getAge());

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

package com.shengsiyuan.hibernate04;

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
		Student student = new Student();
		student.setName("zhangsan");

		IdCard idCard = new IdCard();
		idCard.setNumber(987654);

		student.setIdCard(idCard);
		idCard.setStudent(student);

		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try
		{
			tx = session.beginTransaction();

			session.save(student);

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

	//---------------------------------------------------

//		Session session = sessionFactory.openSession();
//		Transaction tx = null;
//
//		Student student = null;
//
//		try
//		{
//			tx = session.beginTransaction();
//
//			student = (Student)session.get(Student.class, "402881ec2ebd7e77012ebd7e79e40001");
//
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
//		System.out.println(student.getName());
//		System.out.println(student.getIdCard().getNumber());

		//-----------------------------------------

//		Session session = sessionFactory.openSession();
//		Transaction tx = null;
//
//		Student student = null;
//
//		try
//		{
//			tx = session.beginTransaction();
//
//			student = (Student)session.get(Student.class, "402881ec2ebd7e77012ebd7e79e40001");
//
//			student.setName("lisi");
//
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
//		System.out.println(student.getName());

		//-----------------------------------------

//		Session session = sessionFactory.openSession();
//		Transaction tx = null;
//
//		Student student = null;
//
//		try
//		{
//			tx = session.beginTransaction();
//
//			student = (Student)session.get(Student.class, "402881ec2ebd7e77012ebd7e79e40001");
//
//			session.delete(student);
//
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











	}
}

package com.shengsiyuan.hibernate06;

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
//		Student student = new Student();
//		student.setName("wangwu");
//
//		Course course = new Course();
//		course.setName("economic");
//
//		student.setCourses(new HashSet<Course>());
//		course.setStudents(new HashSet<Student>());
//
//		student.getCourses().add(course);
//		course.getStudents().add(student);
//
//		Session session = sessionFactory.openSession();
//		Transaction tx = null;
//
//		try
//		{
//			tx = session.beginTransaction();
//
//			session.save(student);
//
//			tx.commit();
//		}
//		catch(Exception ex)
//		{
//			ex.printStackTrace();
//
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

		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try
		{
			tx = session.beginTransaction();

			Student student = (Student)session.get(Student.class,"402881ec2ebdf5ad012ebdf5afb60001");
			Course course = (Course)session.get(Course.class, "402881ec2ebdf730012ebdf732cc0002");

			//student.getCourses().add(course);
			//course.getStudents().add(student);

			student.getCourses().remove(course);

//			Set<Course> set = student.getCourses();
//
//			for(Iterator<Course> iter = set.iterator(); iter.hasNext();)
//			{
//				System.out.println(iter.next().getName());
//			}



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

package com.shengsiyuan.hibernate;

import java.util.HashSet;

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
		
		Team team = new Team();
		team.setName("team1");
		
		team.setStudents(new HashSet<Student>());
		team.getStudents().add(student);
		
		student.setTeam(team);
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			
			//session.save(team);
			
//			Team t = (Team)session.get(Team.class, "402881ec2ebdc12c012ebdc12e9c0001");
//			
//			System.out.println(t.getName());
			
			Student s = (Student)session.get(Student.class, "402881ec2ebdc12c012ebdc12edb0002");
			
			System.out.println(s.getName());
			
			
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
		
	
		
		
		
		
		
		
		
		
		
		
		
	}
}

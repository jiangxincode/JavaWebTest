package com.shengsiyuan.hibernate;

import java.util.List;

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
			
//			Student student = new Student();
//			student.setCardId("123456");
//			student.setName("zhangsan");
//			
//			Teacher teacher = new Teacher();
//			teacher.setSalary(100);
//			teacher.setName("lisi");
//			
//			session.save(student);
//			session.save(teacher);
			
			Query query = session.createQuery("from Person"); //∂‡Ã¨≤È—Ø
			
//			Iterator iter = query.iterate();
//			
//			while(iter.hasNext())
//			{
////				Person p = (Person)iter.next();
////			
////				System.out.println(p.getClass().getName());
////				
////				System.out.println(p.getName());
//				
//				Object object = iter.next();
//				
//				if(object instanceof Student)
//				{
//					System.out.println(((Student)object).getCardId());
//				}
//				
//				
//			}
			
			List list = query.list();
			
			for(int i = 0; i < list.size(); i++)
			{
				if(list.get(i) instanceof Student)
				{
					System.out.println(((Student) list.get(i)).getCardId());
				}
				
				if(list.get(i) instanceof Teacher)
				{
					System.out.println(((Teacher) list.get(i)).getSalary());
				}
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

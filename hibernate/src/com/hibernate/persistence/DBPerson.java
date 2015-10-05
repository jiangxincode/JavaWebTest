package com.hibernate.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Person;
import com.hibernate.util.HibernateUtil;

public class DBPerson
{
	/**
	 * 创建新的用户
	 */
	
	public static void save(Person person)
	{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction(); //开启事务
		
		try
		{
			session.save(person);
			tx.commit();
		}
		catch(Exception ex)
		{
			System.out.println("增加用户异常发生！");
			if(null != tx)
			{
				tx.rollback();
			}
		}
		finally
		{
			HibernateUtil.closeSession(session);
		}
		
	}
	
	/**
	 * 查询出所有用户
	 */
	
	@SuppressWarnings("unchecked")
	public static List<Person> listAll()
	{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction(); //开启事务
		
		List<Person> list = null;
		
		try
		{
			Query query = session.createQuery("from Person"); //hql语句，Hibernate查询语句
			
			list = (List<Person>)query.list();
			
			tx.commit();
		}
		catch(Exception ex)
		{
			System.out.println("增加用户异常发生！");
			if(null != tx)
			{
				tx.rollback();
			}
		}
		finally
		{
			HibernateUtil.closeSession(session);
		}
		
		return list;
	}
	
	public static Person getPersonById(Integer id)
	{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction(); //开启事务
		
		Person person = null;
		
		try
		{
			//Object get(Class clazz, Serializable id)
			person = (Person)session.get(Person.class, id);
			
			tx.commit();
		}
		catch(Exception ex)
		{
			System.out.println("增加用户异常发生！");
			if(null != tx)
			{
				tx.rollback();
			}
		}
		finally
		{
			HibernateUtil.closeSession(session);
		}
		
		return person;
	}
	
	
	public static void removePerson(Integer id)
	{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction(); //开启事务
		
		try
		{
			Person person = (Person)session.get(Person.class,id);
			session.delete(person);
			
			tx.commit();
		}
		catch(Exception ex)
		{
			System.out.println("增加用户异常发生！");
			if(null != tx)
			{
				tx.rollback();
			}
		}
		finally
		{
			HibernateUtil.closeSession(session);
		}
	}
	
	public static void updatePerson(Person person)
	{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction(); //开启事务
		
		try
		{
			session.update(person);
			
			tx.commit();
		}
		catch(Exception ex)
		{
			System.out.println("增加用户异常发生！");
			if(null != tx)
			{
				tx.rollback();
			}
		}
		finally
		{
			HibernateUtil.closeSession(session);
		}
	}
	
	
}

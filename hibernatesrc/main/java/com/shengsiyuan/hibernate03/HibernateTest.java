package com.shengsiyuan.hibernate;

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
		/*
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			
			Customer customer = new Customer();
			customer.setName("zhangsan");
			customer.setOrders(new HashSet());
			
			Order order1 = new Order();
			order1.setOrderNumber("order1");
			
			Order order2 = new Order();
			order2.setOrderNumber("order2");
			
			Order order3 = new Order();
			order3.setOrderNumber("order3");
			
			order1.setCustomer(customer);
			order2.setCustomer(customer);
			order3.setCustomer(customer);
			
			customer.getOrders().add(order1);
			customer.getOrders().add(order2);
			customer.getOrders().add(order3);
			
			session.save(customer);
			
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
	
	*/
	
		/*
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		Customer customer = null;
		
		try
		{
			tx = session.beginTransaction();
			
			customer = (Customer)session.get(Customer.class, new Long(1));
			
			System.out.println(customer.getName());
			
			//Set set = customer.getOrders();
			
			//System.out.println(set);
			
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
		
		Set orders = customer.getOrders();
		
		System.out.println(((Order)orders.iterator().next()).getId());
		
//		
//		for(Iterator iter = orders.iterator(); iter.hasNext();)
//		{
//			Order order = (Order)iter.next();
//			
//			System.out.println(order.getOrderNumber());
//		}
//		

*/
	
		/*
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		Order order = null;
		
		try
		{
			tx = session.beginTransaction();
			
			order = (Order)session.get(Order.class, new Long(1));
			
			System.out.println(order.getOrderNumber());
			
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
		
		System.out.println(order.getCustomer().getName());
	
	*/
	
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		Customer customer = null;
		
		try
		{
			tx = session.beginTransaction();
			
			customer = (Customer)session.get(Customer.class, new Long(2));
			
			session.delete(customer);
			
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

package com.shengsiyuan.hibernate;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTest2
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
			
//			Category category1 = new Category("level1", null, new HashSet<Category>());
//			Category category2 = new Category("level2", null, new HashSet<Category>());
//			Category category3 = new Category("level2", null, new HashSet<Category>());
//			Category category4 = new Category("level3", null, new HashSet<Category>());
//			Category category5 = new Category("level3", null, new HashSet<Category>());
//			Category category6 = new Category("level3", null, new HashSet<Category>());
//			Category category7 = new Category("level3", null, new HashSet<Category>());
//			
//			category2.setParentCategory(category1);
//			category3.setParentCategory(category1);
//			
//			category1.getChildCategories().add(category2);
//			category1.getChildCategories().add(category3);
//			
//			category4.setParentCategory(category2);
//			category5.setParentCategory(category2);
//			
//			category2.getChildCategories().add(category4);
//			category2.getChildCategories().add(category5);
//			
//			category6.setParentCategory(category3);
//			category7.setParentCategory(category3);
//			
//			category3.getChildCategories().add(category6);
//			category3.getChildCategories().add(category7);
//			
//			System.out.println(session.save(category1));
			
			Category category = (Category)session.load(Category.class, new Long(8));
			Category category_ = (Category)session.load(Category.class, new Long(8));
			
			System.out.println(category.getName());
			System.out.println(category_.getName());
			
			System.out.println(category == category_);
			
			
			
			
			
			
//			Category category = (Category)session.get(Category.class, new Long(1));
//			
//			System.out.println(category.getChildCategories().iterator().next().getName());
//			
//			session.delete(category);
			
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

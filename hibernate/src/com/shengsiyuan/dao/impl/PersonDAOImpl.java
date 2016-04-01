package com.shengsiyuan.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shengsiyuan.dao.PersonDAO;
import com.shengsiyuan.model.Person;
import com.shengsiyuan.util.HibernateUtil;

public class PersonDAOImpl implements PersonDAO
{
	@Override
	public void savePerson(Person person)
	{
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		try
		{
			session.save(person);
			
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
			HibernateUtil.close(session);
		}
	}
}

package com.shengsiyuan.hibernate02.interceptor;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

public class TestInterceptor extends EmptyInterceptor
{
	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types)
	{
		System.out.println("onLoad invoked");

		for(String propertyName : propertyNames)
		{
			System.out.println(propertyName);
		}

		return true;
	}

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types)
	{
		System.out.println("onSave invoked");

		for(String propertyName : propertyNames)
		{
			System.out.println(propertyName);
		}

		return true;
	}

	@Override
	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types)
	{
		System.out.println("onDelete invoked");

		for(String propertyName : propertyNames)
		{
			System.out.println(propertyName);
		}
	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types)
	{
		System.out.println("onFlushDirty invoked");

		for(String propertyName : propertyNames)
		{
			System.out.println(propertyName);
		}

		return true;
	}

	@Override
	public void postFlush(Iterator entities)
	{
		System.out.println("postFlush invoked");
	}

	@Override
	public void beforeTransactionCompletion(Transaction tx)
	{
		System.out.println("beforeTransactionCompletion invoked");
	}

	@Override
	public void afterTransactionCompletion(Transaction tx)
	{
		System.out.println("afterTransactionCompletion invoked");
	}
}

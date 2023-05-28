package com.shengsiyuan.hibernate02.event;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.internal.DefaultLoadEventListener;

public class TestLoadListener extends DefaultLoadEventListener
{
	@Override
	public void onLoad(LoadEvent arg0, LoadType arg1) throws HibernateException
	{
		super.onLoad(arg0, arg1);

		System.out.println("onLoad invoked!!!!");

		System.out.println(arg0.getEntityId() + ", " + arg0.getEntityClassName());
	}
}

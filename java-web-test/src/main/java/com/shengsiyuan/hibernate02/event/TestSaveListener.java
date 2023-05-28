package com.shengsiyuan.hibernate02.event;

import java.io.Serializable;

import org.hibernate.event.SaveOrUpdateEvent;
import org.hibernate.event.def.DefaultSaveEventListener;

public class TestSaveListener extends DefaultSaveEventListener
{
	@Override
	protected Serializable performSaveOrUpdate(SaveOrUpdateEvent event)
	{
		System.out.println("performSaveOrUpdate invoked!!!");

		return super.performSaveOrUpdate(event);
	}
}

package com.shengsiyuan.service.impl;

import com.shengsiyuan.dao.PersonDAO;
import com.shengsiyuan.dao.impl.PersonDAOImpl;
import com.shengsiyuan.model.Person;
import com.shengsiyuan.service.PersonService;

public class PersonServiceImpl implements PersonService
{
	public void savePerson(Person person)
	{
		PersonDAO personDAO = new PersonDAOImpl();
		
		personDAO.savePerson(person);
	}

}

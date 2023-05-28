package com.shengsiyuan.hibernate01.service.impl;

import java.util.List;

import com.shengsiyuan.hibernate01.dao.PersonDAO;
import com.shengsiyuan.hibernate01.dao.impl.PersonDAOImpl;
import com.shengsiyuan.hibernate01.model.Person;
import com.shengsiyuan.hibernate01.service.PersonService;

public class PersonServiceImpl implements PersonService
{
	public void savePerson(Person person)
	{
		PersonDAO personDAO = new PersonDAOImpl();

		personDAO.savePerson(person);
	}

	@Override
	public List<Person> listAllPersons()
	{
		PersonDAO personDAO = new PersonDAOImpl();

		return personDAO.listAllPersons();
	}

	@Override
	public void removePerson(String id)
	{
		PersonDAO personDAO = new PersonDAOImpl();

		personDAO.removePerson(id);
	}

	@Override
	public Person getSinglePersonById(String id)
	{
		PersonDAO personDAO = new PersonDAOImpl();

		return personDAO.getSinglePersonById(id);
	}

	@Override
	public void updatePerson(Person person)
	{
		PersonDAO personDAO = new PersonDAOImpl();

		personDAO.updatePerson(person);
	}

}

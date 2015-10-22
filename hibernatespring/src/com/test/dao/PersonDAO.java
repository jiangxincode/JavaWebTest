package com.test.dao;

import java.util.List;

import lee.PersonBean;

public interface PersonDAO {
	
	public void createPerson(PersonBean person);
	
	public PersonBean getPerson(int id);
	
	public List findPersonsByName(String name);
	
	public void deletePerson(int id);
	
	public void updatePerson(PersonBean person);
}

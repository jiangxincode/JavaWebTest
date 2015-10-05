package com.test.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hibernate.model.Person;
import com.hibernate.persistence.DBPerson;
import com.opensymphony.xwork2.ActionSupport;

public class PersonAction extends ActionSupport
{
	private int id;

	private String username;

	private String password;

	private int age;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	// 完成用户增加的操作
	public String save() throws Exception
	{
		Person person = new Person();

		person.setUsername(username);
		person.setPassword(password);
		person.setAge(age);

		java.sql.Date registerDate = new java.sql.Date(new java.util.Date()
				.getTime());

		person.setRegisterdate(registerDate);

		DBPerson.save(person); // 将person对象存到数据库中

		List<Person> list = DBPerson.listAll();

		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("list", list);

		return SUCCESS;
	}

	public String getPerson() throws Exception
	{
		Person person = DBPerson.getPersonById(id);

		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("person", person);

		return SUCCESS;
	}

	public String deletePerson() throws Exception
	{
		DBPerson.removePerson(id);

		List<Person> list = DBPerson.listAll();

		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("list", list);

		return SUCCESS;
	}

	public String updatePerson() throws Exception
	{
		Person person = DBPerson.getPersonById(id);

		person.setPassword(password);
		person.setAge(age);

		DBPerson.updatePerson(person);

		List<Person> list = DBPerson.listAll();

		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("list", list);

		return SUCCESS;
	}

}

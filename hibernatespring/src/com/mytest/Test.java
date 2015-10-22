package com.mytest;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.test.dao.PersonDAO;

import lee.PersonBean;

public class Test {
	
	public static void main(String[] args) {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		
		PersonDAO dao = (PersonDAO)factory.getBean("personDao");
		
		PersonBean person = new PersonBean();
		person.setName("zhangsan");
		person.setAge(20);
		
		//dao.createPerson(person);
		
		PersonBean p = dao.getPerson(1);
		System.out.println(p.getName() + " " + p.getAge());
		
		
		dao.deletePerson(1);
		
	}

}

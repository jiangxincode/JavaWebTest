package com.shengsiyuan.struts2ajax.action.ognl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class OgnlAction extends ActionSupport implements RequestAware, SessionAware, ApplicationAware
{
	private String username;

	private String password;

	private Map<String, Object> requestMap;

	private Map<String, Object> sessionMap;

	private Map<String, Object> applicationMap;

	private List<Person> list;

	public List<Person> getList()
	{
		return list;
	}

	public void setList(List<Person> list)
	{
		this.list = list;
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

	@Override
	public void setRequest(Map<String, Object> arg0)
	{
		System.out.println("setRequest invoked");

		this.requestMap = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0)
	{
		System.out.println("setSession invoked!");

		this.sessionMap = arg0;
	}

	@Override
	public void setApplication(Map<String, Object> arg0)
	{
		this.applicationMap = arg0;
	}

	@Override
	public String execute() throws Exception
	{
		Thread.sleep(20000);

		requestMap.put("hello", "world");
		sessionMap.put("hello","hello");
		applicationMap.put("hello", "hello world");

		Cat cat1 = new Cat("cat1", 20, "red");
		Cat cat2 = new Cat("cat2", 30, "blue");

		String[] friends1 = {"test1", "test2", "test3"};
		String[] friends2 = {"welcome1", "welcome2", "welcome3"};

		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();

		map1.put("test1", "test1");
		map1.put("test2", "test2");

		map2.put("hello1", "hello1");
		map2.put("hello2", "hello2");

		Person person1 = new Person("zhangsan", 20, "beijing", friends1, cat1, map1);
		Person person2 = new Person("lisi", 30, "shanghai", friends2, cat2, map2);

		list = new ArrayList<Person>();

		list.add(person1);
		list.add(person2);

		return SUCCESS;
	}
}

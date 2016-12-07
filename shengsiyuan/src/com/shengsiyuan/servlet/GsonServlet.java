package com.shengsiyuan.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.shengsiyuan.model.Address;
import com.shengsiyuan.model.People;

public class GsonServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		List<People> list = new ArrayList<People>();
			
		People people1 = new People();
		
		Address address1 = new Address();
		address1.setHomeAddress("beijing");
		address1.setCompanyAddress("shanghai");
		
		people1.setId(1);
		people1.setName("zhangsan");
		people1.setAddress(address1);
		
		People people11 = new People();
		people11.setId(5);
		people11.setName("zhangsan11");
		
		People people12 = new People();
		people12.setId(6);
		people12.setName("zhangsan12");
		
		
		List<People> list1 = new ArrayList<People>();
		list1.add(people11);
		list1.add(people12);
		
		people1.setFriends(list1);
		
		System.out.println("---------------");
		
		People people2 = new People();
		
		Address address2 = new Address();
		address2.setCompanyAddress("liaoning");
		address2.setHomeAddress("jilin");
		
		people2.setId(2);
		people2.setName("lisi");
		people2.setAddress(address2);
		
		
		List<People> list2 = new ArrayList<People>();
		
		People people21 = new People();
		people21.setId(3);
		people21.setName("lisi11");
		
		People people22 = new People();
		people22.setId(4);
		people22.setName("lisi12");
		
		list2.add(people21);
		list2.add(people22);
		
		people2.setFriends(list2);
		
		list.add(people1);
		list.add(people2);
		
		Gson gson = new Gson();
		
		String result = gson.toJson(list);
		
		System.out.println(result);
		
		resp.setContentType("application/json; charset=utf-8");
		
		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-control", "no-cache");
		
		PrintWriter out = resp.getWriter();
		
		out.println(result);
		
		out.flush();
	}
}

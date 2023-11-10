package com.shengsiyuan.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.shengsiyuan.model.Person;

public class XMLServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		String name = req.getParameter("name");
		
		Person person = new Person();
		
		if("zhangsan".equals(name))
		{
			person.setId(1);
			person.setName("zhangsan");
			person.setAddress("beijing");
			person.setAge(30);
		}
		else
		{
			person.setId(2);
			person.setName("lisi");
			person.setAddress("shanghai");
			person.setAge(20);
		}
		
		Document document = DocumentHelper.createDocument();
		
		Element rootElement = document.addElement("users");
		
		rootElement.addComment("This is a comment!");
		
		Element userElement = rootElement.addElement("user");
		
		Element idElement = userElement.addElement("id");
		Element nameElement = userElement.addElement("name");
		Element ageElement = userElement.addElement("age");
		Element addressElement = userElement.addElement("address");
		
		idElement.setText(person.getId() + "");
		nameElement.setText(person.getName());
		ageElement.setText(person.getAge() + "");
		addressElement.setText(person.getAddress());
		
		resp.setContentType("text/xml; charset=utf-8");
		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-control", "no-cache");
		
		PrintWriter out = resp.getWriter();
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		
		XMLWriter xmlWriter = new XMLWriter(out, format);
		
		xmlWriter.write(document);
		
		out.flush();

	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		this.doPost(req, resp);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

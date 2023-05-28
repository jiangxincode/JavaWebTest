<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="javax.swing.JFrame"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'result.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   
  <% 
   /*
    Enumeration e = request.getParameterNames();
  	
  	 while(e.hasMoreElements())
  	 {
		System.out.println(e.nextElement());  		 
  	 }
  
     String[] values = request.getParameterValues("age");
     
     for(String value : values)
     {
		System.out.println(value);    	 
     }*/
     
     String value = request.getParameter("age");
     
     System.out.println(value);
  
  %>



   
   
  <% String username = request.getParameter("username1");
  	 String password = request.getParameter("password1");
  	 
  	 out.print("username: " + username + "<br>");
  	 out.println("password: " + password + "<br>");
  	 
  	 
  	 //JFrame frame = new JFrame("title");
  	 //frame.getContentPane().add(new javax.swing.JButton("button"));
  	 //frame.setVisible(true);
  %>
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
  </body>
</html>

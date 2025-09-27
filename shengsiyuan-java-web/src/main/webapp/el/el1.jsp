<%@ page language="java" import="com.shengsiyuan.bean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'el1.jsp' starting page</title>
    
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
    
    <form action="el2.jsp">
    
    username: <input type="text" name="username"><br>
    
    <input type="text" name="interest"><br>
    <input type="text" name="interest"><br>
    <input type="text" name="interest"><br>
    <input type="text" name="interest"><br>
    <input type="text" name="interest"><br>
    
    <input type="submit" value="submit">
    
    </form>
    
    <% session.setAttribute("hello", "world"); %>
    
    <% Person person = new Person();
       session.setAttribute("person", person);
    %>
    
    
    
    
    
    
    
    
    
    
    
    
  </body>
</html>

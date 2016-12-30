<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updatePerson.jsp.jsp' starting page</title>
    
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
  
  <form action="updatePerson.action">
  
  username: <s:textfield name="username" value="%{#request.person.username}" readonly="true"></s:textfield><br>
  password: <s:password name="password" value="%{#request.person.password}"></s:password><br>
  age: <s:textfield name="age" value="%{#request.person.age}"></s:textfield><br>
  registerDate: <s:textfield name="registerDate" value="%{#request.person.registerDate}" readonly="true"></s:textfield><br>
  
  <s:hidden name="id" value="%{#request.person.id}"></s:hidden>
  
  
  <input type="submit" value="submit">
  
  </form>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  </body>
</html>

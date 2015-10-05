<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updatePerson.jsp' starting page</title>
    
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
   
   <form action="updatePerson.action" method="post">
   
   	username: <s:textfield name="username" value="%{#request.person.username}" readonly="true"></s:textfield><br>
   	
   	password: <s:textfield name="password" value="%{#request.person.password}"></s:textfield><br>
   	
   	age: <s:textfield name="age" value="%{#request.person.age}"></s:textfield><br>
   	
   	registerdate: <s:textfield name="registerdate" value="%{#request.person.registerdate}" readonly="true"></s:textfield><br>
   	
   	<s:hidden name="id" value="%{#request.person.id}"></s:hidden>
   	
   	<input type="submit" value="submit">
   
   
   </form>
   
   
   
   
   
  </body>
</html>

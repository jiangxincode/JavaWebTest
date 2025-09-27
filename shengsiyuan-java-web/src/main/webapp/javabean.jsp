<%@ page language="java" import="com.shengsiyuan.bean.Person" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'javabean.jsp' starting page</title>
    
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
   
   <jsp:useBean id="person" class="com.shengsiyuan.bean.Person" scope="application"></jsp:useBean>
   
   <jsp:getProperty property="name" name="person"/><br>
   <jsp:getProperty property="age" name="person"/><br>
   <jsp:getProperty property="address" name="person"/><br>
   
   <jsp:setProperty property="name" name="person" value="lisi"/>
   
   <jsp:getProperty property="name" name="person"/><br>
   
   <%= person.getName()%>
   
   <jsp:setProperty property="age" name="person" param="helloworld"/><br>
   
   <jsp:getProperty property="age" name="person"/>
   
   <jsp:forward page="javabean2.jsp"></jsp:forward>
   
   
   
   
   
   
   
   
   
  </body>
</html>

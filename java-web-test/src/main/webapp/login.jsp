<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.net.*" %>
<%@ page import="java.lang.reflect.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
    
    <!-- 这是HTML注释 -->
    <!-- <%= new java.util.Date() %> -->
    <%-- 这是JSP注释 --%>
    <%-- new java.util.Date(); --%>
    
    <!-- <form action="LoginServlet" method="get"> -->
    <form action="result.jsp" method="post">
    
    username: <input type="text" name="username1"><br>
    password: <input type="password" name="password1"><br>
    
    age: <input type="text" name="age"><br>
    age2: <input type="text" name="age"><br>
    
    <input type="submit" value="submit">&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="reset" value="reset">
    
    
    </form>
    
    <a href="staruml.exe">link</a>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  </body>
</html>

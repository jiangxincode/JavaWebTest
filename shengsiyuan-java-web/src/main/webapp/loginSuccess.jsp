<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loginSuccess.jsp' starting page</title>
    
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
    
  用户名：<%= request.getAttribute("username") %><br>
 密码：<%= request.getAttribute("password") %> <br>
 性别：<%= request.getAttribute("gender") %> <br>
兴趣：<% String[] interest = (String[])request.getAttribute("interest");
for(String str : interest)
{
%>
 <%= str %> &nbsp;&nbsp;
 
 <%} %>   

<br>

地址：<%= request.getAttribute("address") %><br>   
说明：<%= request.getAttribute("comment") %> 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  </body>
</html>

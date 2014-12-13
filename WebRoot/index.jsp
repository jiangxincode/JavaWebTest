<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Some JavaWeb</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="JavaWeb,Exercise,Emample">
	<meta http-equiv="description" content="Some Java Web Examples">
	<link rel="stylesheet" type="text/css" href="CSS/index.css">
  </head>
  
  <body>
    <h1>Some Java Web Examples</h1>
    <ol class="rounded-list">
    	<li><a href="JSP/GuessNumberJsp/input.jsp">猜数字，采用JSP实</a></li>
    	<li><a href="GuessNumber">猜数字，使用Servlet和JSP实现</a></li>
    	<li><a href="Click">历史访问量统计</a></li>
    	<li><a href="BookAdmin">数据库应用</a></li>
    </ol>
  </body>
</html>

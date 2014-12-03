<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Some Java Web Examples</title>
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
    Some Java Web Examples。<br />
    ${param.basePath}
    <ol>
    	<li><a href="JSP/GuessNumberJsp/input.jsp">猜数字，采用jsp实</a></li>
    	<li>猜数字，使用servlet实现</li>
    	<li>在线人数统计</li>
    	<li>数据库应用</li>
    </ol>
  </body>
</html>

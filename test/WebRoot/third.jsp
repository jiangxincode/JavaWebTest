<%@ page language="java" import="java.util.Calendar" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'third.jsp' starting page</title>
    
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
    
    <%Calendar calendar = Calendar.getInstance();
	int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
	%>
    <%if(currentHour < 12){%>
	Good Morning!
	<%} else if(currentHour > 12 && currentHour < 18){%>
	Good Afternoon!
	<%}else{%>
	Good Evening!
	<%}%>
    
    
    
    
  </body>
</html>

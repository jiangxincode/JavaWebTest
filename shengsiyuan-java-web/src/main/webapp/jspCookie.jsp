<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jspCookie.jsp' starting page</title>
    
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
    
    <%! int count1 = 0;
    	int count2 = 0;
    	%>
    <% Cookie cookie = new Cookie("cookieName" + count1++, "cookieValue" + count2++); 
    
    	cookie.setMaxAge(15);
    	
    	response.addCookie(cookie);
    
    %>
    
    <%
    	Cookie[] cookies = request.getCookies();
    
    	if(null == cookies)
    	{
			return;    		
    	}
    	
    	for(Cookie c : cookies)
    	{
    
    %>
    <p>
    	<b>cookie name: </b> <%= c.getName() %><br>
    	
    	<b>cookie value: </b><%= c.getValue() %>
    </p>
    
    <%} %>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  </body>
</html>

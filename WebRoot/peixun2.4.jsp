<%@ page language="java" import="java.util.*" pageEncoding="gb2312" %>
<%@ page contentType="text/html;charset=gb2312" %>

<html>
<head>
<title> test </title>
</head>
<body>
<center>
<%! Date date=new Date(); %> 
<%! int a, b, c; %>


<% a=12;b=a; c=a+b;%>
<font color="blue">
<%=date.toString()%>
</font><br> 
<b>a=<%= a %></b><br>
<b>b=<%= b %></b><br>
<b>c=<%= c %></b><br>
</center>	
</body>
</html>

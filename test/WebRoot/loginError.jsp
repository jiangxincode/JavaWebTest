<%@ page language="java" pageEncoding="utf-8" %>
<%@ page import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<%List<String> list = (List<String>)request.getAttribute("errorMessage");%>

<html>
<head>
<title>login error</title>
</head>
<body bgcolor="#FFFFFF">
错误信息如下：<br><br><br>
<%
String errorMessage = null;
for(int i = 0; i < list.size(); i++)
{
errorMessage = list.get(i);
%>
<li><font color="#ff0000"><%= errorMessage%></font><br>

<%}%>

</body>
</html>
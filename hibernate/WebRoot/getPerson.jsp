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
    
    <title>My JSP 'getPerson.jsp' starting page</title>
    
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
   
   <table width="70%" align="center" border="1">
   
   	<tr>
   	<td>username:
   	</td>
   	<td><s:property value="#request.person.username"/>
   	</td>
   	</tr>
   	
   	<tr>
   	<td>password:
   	</td>
   	<td><s:property value="#request.person.password"/>
   	</td>
   	</tr>
   	
   	<tr>
   	<td>age:
   	</td>
   	<td><s:property value="#request.person.age"/>
   	</td>
   	</tr>
   
   	<tr>
   	<td>registerdate:
   	</td>
   	<td><s:property value="#request.person.registerdate"/>
   	</td>
   	</tr>
   	
   	<tr>
   	<td colspan="2"><input type="button" value="back" onclick="javascript:history.back();">
   	</td>
   	</tr>
   
   
   </table>
   
   
   
   
  </body>
</html>

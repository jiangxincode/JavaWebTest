<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'input.jsp' starting page</title>
    
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
    
    <h1>������һ���������(ʹ�ö��ŷָ���)</h1>
    
    <form action="converterAction.action" method="post">
    
    <!-- 
      
    ����:<input type="text" name="point" size="20"><br>
    ����2:<input type="text" name="point" size="20"><br>
    ����3:<input type="text" name="point" size="20"><br>
     -->
     
     
   x:<input type="text" name="point.x" size="20"><br>
   y:<input type="text" name="point.y" size="20"><br>  
   �û���:<input type="text" name="username" size="20"><br>
   ����:<input type="text" name="age" size="20"><br>
   ��������:<input type="text" name="birthday" size="20"><br>
   
   <input type="submit" value="submit">
    
    
    
    
    </form>
    
    
    
    
  </body>
</html>

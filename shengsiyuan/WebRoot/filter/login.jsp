<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 <base href="<%=basePath%>">
  </head>
  
  <body>
    
    <% String username = request.getParameter("username");
       String authority = request.getParameter("authority");
    %>
    
    
    <form action="MyLoginServlet" method="post">
    
    username: <input type="text" name="username" value='<%= null == username ? "" : username %>'><br>
    password: <input type="password" name="password"><br>
    
    authority: 
    <select name="authority">
    	<option value="1" <%= "1".equals(authority) ?  "selected='selected'" : ""%>>common user</option>
    	<option value="2" <%= "2".equals(authority) ?  "selected='selected'" : "" %>>administrator</option>
    </select>
    
    <br>
    
    <input type="submit" value="submit">
    
    </form>
    
  </body>
</html>

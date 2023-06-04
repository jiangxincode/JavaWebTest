<%@ page language="java" pageEncoding="gb2312"%> 
<%@ page contentType="text/html;charset=gb2312"%>
<html>
<head><title>post.jsp</title></head>
<body>

 <%! String name=""; %> 

<%  
	name = request.getParameter("username"); 
	//将username存入session 
	session.setAttribute("username", name);  
%> 
您的姓名是：<%=name%>  
<br><form method="post" action="post11.jsp"> 
您最喜欢的娱乐是：  
<input type="text" name="amuse"> 
<input type="submit" value="submit">
</form> 
</body> 
</html>

<%@ page language="java" pageEncoding="gb2312"%> 
<%@ page contentType="text/html;charset=gb2312"%>
<html>
<head><title>post.jsp</title></head>
<body>

 <%! String name=""; %> 

<%  
	name = request.getParameter("username"); 
	//��username����session 
	session.setAttribute("username", name);  
%> 
���������ǣ�<%=name%>  
<br><form method="post" action="post11.jsp"> 
����ϲ���������ǣ�  
<input type="text" name="amuse"> 
<input type="submit" value="submit">
</form> 
</body> 
</html>

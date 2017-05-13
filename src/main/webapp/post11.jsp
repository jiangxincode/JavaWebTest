<%@ page contentType="text/html;charset=gb2312" pageEncoding="gbk"%>
<html>
	<head><title>post1.jsp</title></head>
<body>
<%@ page language="java"%>
<%! String amuse=""; %>
<%
	amuse=request.getParameter("amuse");
	String user=(String)session.getAttribute("username");
%>
您的姓名是： <%=user%>
您喜欢的娱乐是： <%=amuse%>
</body>
</html> 

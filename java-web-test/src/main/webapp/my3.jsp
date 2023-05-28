<%@ page language="java"%>
<%@ page contentType="text/html;charset=gb2312"%>
<html>
	<head>
		<title>post1.jsp</title>
	</head>
	<body>
		
		<% String amuse = "";%>
		<%
			amuse = request.getParameter("amuse");
			String user = (String) session.getAttribute("username");
		%>
		您的姓名是：
		<%= request.getParameter("username")%>
		您喜欢的娱乐是：
		<%= amuse%>
	</body>
</html>
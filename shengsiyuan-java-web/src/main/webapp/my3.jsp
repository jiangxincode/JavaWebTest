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
		���������ǣ�
		<%= request.getParameter("username")%>
		��ϲ���������ǣ�
		<%= amuse%>
	</body>
</html>
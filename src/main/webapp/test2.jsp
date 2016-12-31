<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Hi-JSP实验</title>
	</head>
	<body>
		<%
			String msg = "This is JSP test.";
			out.print("Hello World!");
		%>
		<h2><%= msg%></h2>
	</body>
</html>
<%@ page contentType="text/html;charset=gb2312"%>
<html>
	<head>
		<title>test</title>
	</head>
	
	<body>
		
		<jsp:forward page="forwardTo.jsp">
			<jsp:param name="userName" value="riso" />
			<jsp:param value="world" name="hello"/>
		</jsp:forward>
		
		<%System.out.println("hello world"); %>
		
	</body>
	
</html>
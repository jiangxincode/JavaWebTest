<%@ page contentType="text/html;charset=gb2312" pageEncoding="gb2312" %>
<html>
	<head>
		<title>test</title>
	</head>
	<body>
		<jsp:forward page="forwardTo.jsp">
			<jsp:param name="userName" value="riso"/>
		</jsp:forward>
<%System.out.println("�˶δ��벻�ᱻִ��");%>
	</body>
</html>

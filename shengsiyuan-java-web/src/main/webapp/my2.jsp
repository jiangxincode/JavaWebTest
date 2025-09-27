<%@ page language="java"%>
<%@ page contentType="text/html;charset=gb2312"%>
<html>
	<head>
		<title>post.jsp</title>
	</head>
	<body>
	
	<% String username = request.getParameter("username"); %>
	username: <%= username %>
	
				<form method="post" action="my3.jsp">
					Äú×îÏ²»¶µÄÓéÀÖÊÇ£º
					<input type="text" name="amuse">
					<input type="hidden" name="username" value="<%= username%>">
					<input type="submit" value="submit">
				</form>
	</body>
</html>
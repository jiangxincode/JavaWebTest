<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<HTML>
	<BODY>
		<%
			String name = request.getParameter("username");
			
			session.setAttribute("logName", name);
		%>
		
		你的名字"<%= name%>"已经写入session
		
		<br>
		
		<a href='session3.jsp'>check</a>
	</BODY>
</HTML>
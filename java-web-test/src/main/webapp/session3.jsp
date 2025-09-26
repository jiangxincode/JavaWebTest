<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<HTML>
	<BODY>
		<% String yourName = (String)session.getAttribute("logName"); 
			
		if (yourName == null) { %>
			
			您还未登录
		
		 <% }else { %>
		
		 "<%= yourName%>"  已经登录
		 
		 <% } %>
	</BODY>
</HTML>
<%@ page contentType="text/html;charset=gb2312" pageEncoding="gb2312" %>
<!--forwardTo.jsp-->

<%
	String useName=request.getParameter("userName");
	String outStr= "лл���٣�";
	outStr += useName;
	out.println(outStr);	
%>

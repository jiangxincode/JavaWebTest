<%@ page contentType="text/html;charset=gb2312" pageEncoding="gb2312" %>
<!--forwardTo.jsp-->

<%
	String useName=request.getParameter("userName");
	String outStr= "谢谢光临！";
	outStr += useName;
	out.println(outStr);	
%>

<%@ page contentType="text/html;charset=gb2312"%>
<!--forwardTo.jsp-->
<%
	String useName = request.getParameter("userName");
	String hello = request.getParameter("hello");
	System.out.println(hello);
	String outStr = "лл���٣�";
	outStr += useName;
	out.println(outStr);
%>
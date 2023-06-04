<%@ page contentType="text/html; charset=GB2312" pageEncoding="gb2312"%>
<%@ page session="true" %>
<html>
<head>
<title>
maillogout
</title>
</head>
<body>

<%

session.invalidate();
String name=(String)session.getAttribute("username");
 %>

<%=name%>,再见！
<p>
<p>
<a href="maillogin.jsp">重新登录邮件系统</a>&nbsp;&nbsp;&nbsp;
</body>
</html>

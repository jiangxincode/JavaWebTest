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

<%=name%>,�ټ���
<p>
<p>
<a href="maillogin.jsp">���µ�¼�ʼ�ϵͳ</a>&nbsp;&nbsp;&nbsp;
</body>
</html>

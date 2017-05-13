<%@ page contentType="text/html; charset=GB2312" pageEncoding="gb2312"%>
<%@ page session="true" %>
<html>
<head>
<title>
checkmail
</title>
</head>
<body>

<%
String name=null;
name=request.getParameter("username");
if(name!=null)session.setAttribute("username",name);
%>

<a href="maillogin.jsp">登录</a>&nbsp;&nbsp;&nbsp;
<a href="maillogout.jsp">注销</a>&nbsp;&nbsp;&nbsp;
<p>当前用户为：<%=name%> </P>
<P>你的信箱中有52封邮件</P>

</body>
</html>

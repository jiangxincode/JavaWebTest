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

<a href="maillogin.jsp">��¼</a>&nbsp;&nbsp;&nbsp;
<a href="maillogout.jsp">ע��</a>&nbsp;&nbsp;&nbsp;
<p>��ǰ�û�Ϊ��<%=name%> </P>
<P>�����������52���ʼ�</P>

</body>
</html>

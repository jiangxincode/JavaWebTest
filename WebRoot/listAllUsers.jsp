<%@ page language="java" pageEncoding="GB2312" %>
<%@ page import="java.util.*,com.test.bean.*"%>

<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<%ArrayList arrayList = (ArrayList)request.getAttribute("all");
Users bean = null;
%>

<html>
<head>
<title>Lomboz JSP</title>
</head>
<body bgcolor="#FFFFFF">
<table width="50%" align="center" border="1">
<tr>
<td>�û���</td>
<td>ɾ��</td>
</tr>
<%for(int i = 0;i < arrayList.size(); i++)
{ bean = (Users)arrayList.get(i);
%>
<tr> 
<td><a href="listSingleUser.jsp?id=<%= bean.getId()%>"><%= bean.getUsername()%></a></td>
<td><a href="/test/ProcessUsersServlet?type=remove&id=<%= bean.getId()%>" onClick="javascript:return confirm('��ȷʵҪɾ���ü�¼ô��')">ɾ��</a></td>
</tr>
<%}%>
</table>
</body>
</html>
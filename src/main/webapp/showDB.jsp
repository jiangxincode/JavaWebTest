<%@ page language="java" pageEncoding="GB2312" %>
<%@ page import="java.util.*,com.test.bean.*"%>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">

<%List list = (List)request.getAttribute("list");
UserBean bean = null;
%>



<html>
<head>
<title>db example</title>
</head>
<body bgcolor="#FFFFFF">

<table border="1" width="80%" align="center">
<tr>
<td align="center">�û���</td>
<td align="center">����</td>
<td align="center">����</td>
<td align="center">��ҳ</td>
<td align="center">�绰</td>
<td align="center">��ַ</td>
<td align="center">�ʱ�</td>
</tr>
<%for(int i = 0 ; i < list.size();i++)
{
bean = (UserBean)list.get(i);
%>
<tr>
<td><%= bean.getName()%></td>
<td><%= bean.getPassword()%></td>
<td><%= bean.getEmail()%></td>
<td><%= bean.getWww()%></td>
<td><%= bean.getTel()%></td>
<td><%= bean.getAddress()%></td>
<td><%= bean.getPostcode()%></td>
</tr>
<%}%>
</table>
</body>
</html>
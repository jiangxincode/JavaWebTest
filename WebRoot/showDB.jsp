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
<td align="center">用户名</td>
<td align="center">密码</td>
<td align="center">邮箱</td>
<td align="center">主页</td>
<td align="center">电话</td>
<td align="center">地址</td>
<td align="center">邮编</td>
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
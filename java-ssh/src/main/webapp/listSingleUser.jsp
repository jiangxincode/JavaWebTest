<%@ page language="java" pageEncoding="GB2312" %>
<%@ page import="java.util.*,com.test.bean.*,com.test.db.*"%>
<%String id = request.getParameter("id");
UsersDB usersDB = new UsersDB();
Users bean = usersDB.restore(Integer.parseInt(id));
%>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Lomboz JSP</title>
</head>
<body bgcolor="#FFFFFF">
<table width="100%" align="center" align="center">
<tr bgcolor="gray">
<td>�û���</td>
<td>����</td>
<td>��ʵ����</td>
<td>����</td>
<td>ע��ʱ��</td>
<td>�Ա�</td>
<td>����</td>
<td>˵��</td>
</tr>
<tr>
<td><%= bean.getUsername()%></td>
<td><%= bean.getPassword()%></td>
<td><%= bean.getTruename()%></td>
<td><%= bean.getBirthday()%></td>
<td><%= bean.getRegisterdate()%></td>
<td><%= "0".equals(bean.getSex()) ? "��" : "Ů"%></td>
<td>
<%String interest = bean.getInterest();%>
<%= interest.indexOf("0") != -1 ? "����" : ""%>&nbsp;
<%= interest.indexOf("1") != -1 ? "����" : ""%>&nbsp;
<%= interest.indexOf("2") != -1 ? "����" : ""%>&nbsp;
<%= interest.indexOf("3") != -1 ? "��ë��" : ""%>&nbsp;



</td>
<td><%= bean.getRemark()%></td>
</tr>
</table>

</body>
</html>
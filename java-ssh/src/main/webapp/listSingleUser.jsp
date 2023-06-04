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
<td>用户名</td>
<td>密码</td>
<td>真实姓名</td>
<td>生日</td>
<td>注册时间</td>
<td>性别</td>
<td>爱好</td>
<td>说明</td>
</tr>
<tr>
<td><%= bean.getUsername()%></td>
<td><%= bean.getPassword()%></td>
<td><%= bean.getTruename()%></td>
<td><%= bean.getBirthday()%></td>
<td><%= bean.getRegisterdate()%></td>
<td><%= "0".equals(bean.getSex()) ? "男" : "女"%></td>
<td>
<%String interest = bean.getInterest();%>
<%= interest.indexOf("0") != -1 ? "足球" : ""%>&nbsp;
<%= interest.indexOf("1") != -1 ? "篮球" : ""%>&nbsp;
<%= interest.indexOf("2") != -1 ? "排球" : ""%>&nbsp;
<%= interest.indexOf("3") != -1 ? "羽毛球" : ""%>&nbsp;



</td>
<td><%= bean.getRemark()%></td>
</tr>
</table>

</body>
</html>
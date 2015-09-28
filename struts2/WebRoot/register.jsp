<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'register.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>

	<table align="center" width="40%" border="0">
		<tr>
			<td><s:actionerror cssStyle="color:red" />
				________________________________________ <s:fielderror
					cssStyle="color:blue"></s:fielderror></td>
		</tr>
	</table>

	<form action="register.action" method="post">

		<table align="center" width="40%" border="1">
			<tr>
				<td>username:</td>
				<td><input type="text" name="username" size="20"></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="password" name="password" size="20"></td>
			</tr>
			<tr>
				<td>re-password:</td>
				<td><input type="password" name="repassword" size="20">
				</td>
			</tr>
			<tr>
				<td>age:</td>
				<td><input type="text" name="age" size="20"></td>
			</tr>
			<tr>
				<td>birthday:</td>
				<td><input type="text" name="birthday" size="20"></td>
			</tr>
			<tr>
				<td>graduation:</td>
				<td><input type="text" name="graduation" size="20"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
				<td><input type="reset" value="reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>

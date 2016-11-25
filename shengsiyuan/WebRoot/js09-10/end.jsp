<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'end.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">

	var value = <%= request.getParameter("number")%>;

	alert(value);


	function checkAll()
	{
		var s = document.getElementsByName("check");
		var m = document.getElementsByName("all")[0];

		if(m.checked)
		{
			for(var i = 0; i < s.length; i++)
			{
				s[i].checked = true;
			}
		}
		else
		{
			for(var i = 0; i < s.length; i++)
			{
				s[i].checked = false;
			}
		}
	}

	function turn()
	{
		with(document)
		{
			var m = getElementById("change");
			var n = getElementById("table");

			if(m.value == "收缩")
			{
				n.style.display = "none";
				m.value = "展开";
			}
			else
			{
				n.style.display = "block";
				m.value = "收缩";
			}
		}
	}

	</script>
</head>

<body>
	<table border="1" align="center" width="60%">

		<tr>
			<td><input type="checkbox" name="all" onclick="checkAll();">全选
			</td>
			<td><input type="button" value="收缩" id="change"
				onclick="turn();"></td>
		</tr>

	</table>

	<% int number = Integer.parseInt(request.getParameter("number")); %>

	<table border="1" align="center" width="60%" id="table">

		<% for(int i = 1; i <= number; i++)
    {%>

		<tr>
			<td><input type="checkbox" name="check"></td>

			<td><%= i %></td>
		</tr>
		<%} %>

	</table>
</body>
</html>

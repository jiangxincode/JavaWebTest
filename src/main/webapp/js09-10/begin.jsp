<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'begin.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">

	function validate()
	{
		var num = document.getElementsByName("number")[0];

		if(num.value.length < 1)
		{
			alert("输入不能为空！");

			num.focus();

			return false;
		}

		for(var i = 0; i < num.value.length; i++)
		{
			var param = "0123456789";

			if(param.indexOf(num.value.charAt(i)) == -1)
			{
				alert("输入必须为数字");

				num.focus();

				return false;
			}
		}

		if(parseInt(num.value) < 5 || parseInt(num.value) > 15)
		{
			num.value = 10;
		}

		return true;
	}



	</script>

</head>

<body>


	<form action="end.jsp" name="form1" method="post"
		onsubmit="return validate();">
		请输入数字 （5——15）<input type="text" name="number"><br> <input
			type="submit" value="submit">
	</form>
</body>
</html>

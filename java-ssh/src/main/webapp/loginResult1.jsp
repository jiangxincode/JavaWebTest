<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">

<%String username = (String)request.getAttribute("username");
String password = (String)request.getAttribute("password");
String sex = (String)request.getAttribute("sex");
String[] interest = (String[])request.getAttribute("interest");
String address = (String)request.getAttribute("address");
String remark = (String)request.getAttribute("remark");
%>

<html>
<head>
<title>login result</title>
</head>
<body bgcolor="#FFFFFF">
姓名：${param.username }<br>
密码：<%= password%><br>
性别：<%= sex%><br>
兴趣：
<%

	for(int i = 0 ; i < interest.length ; i++)
	{

%>
	<%= interest[i] %>
			
<%		
	}	
%><br>
地址：<%= address%><br>
说明：<%= remark%>


</body>
</html>
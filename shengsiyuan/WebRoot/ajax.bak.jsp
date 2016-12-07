<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'ajax.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
    var xmlHttpRequest = null; //声明一个空对象以接收XMLHttpRequest对象

    function ajaxSubmit() {
	if (window.ActiveXObject) // IE浏览器
	{
	    xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) //除IE外的其他浏览器实现
	{
	    xmlHttpRequest = new XMLHttpRequest();
	}

	if (null != xmlHttpRequest) {
	    var v1 = document.getElementById("value1ID").value;
	    var v2 = document.getElementById("value2ID").value;

	    xmlHttpRequest.open("POST", "AjaxServlet", true);
	    //关联好ajax的回调函数
	    xmlHttpRequest.onreadystatechange = ajaxCallback;

	    //真正向服务器端发送数据
	    // 使用post方式提交，必须要加上如下一行
	    xmlHttpRequest.setRequestHeader("Content-Type",
		    "application/x-www-form-urlencoded");
	    xmlHttpRequest.send("v1=" + v1 + "&v2=" + v2);
	}
    }

    function ajaxCallback() {
	if (xmlHttpRequest.readyState == 4) {
	    if (xmlHttpRequest.status == 200) {
		var responseText = xmlHttpRequest.responseText;

		document.getElementById("div1").innerHTML = responseText;
	    }
	}
    }
</script>
</head>
<body>
	<input type="button" value="get content from server"
		onclick="ajaxSubmit();">
	<br>
	<input type="text" name="value1" id="value1ID">
	<br>
	<input type="text" name="value2" id="value2ID">
	<br>
	<div id="div1"></div>
</body>
</html>

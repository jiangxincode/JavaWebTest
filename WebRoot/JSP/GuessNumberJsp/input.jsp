<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html>
<head>
<base href="<%=basePath%>">
<title>Guess Number</title>
<script type="text/javascript"
	src="JavaScript/guess_number.js"></script>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="GuessNumber,Guess,Number">
<meta http-equiv="description" content="A guess number toolkit">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<%
		Integer random = new Random().nextInt(100) + 1;
		session.setAttribute("random", random);
		session.setAttribute("guessTimes", 0);
		Integer totalVisits = (Integer) application
				.getAttribute("totalVisits");
		if (totalVisits == null) {
			totalVisits = 0;
		}
		application.setAttribute("totalVisits", ++totalVisits);
	%>
	<h1>本游戏共开了${totalVisits}局</h1>
	<form action="JSP/GuessNumberJsp/guess.jsp" method="get">
		输入一个<b>1~100</b>之间的数字 <input id="guess_input" type="text" name="input_number">${param.input_number}
		<input type="submit" value="提交" onclick="return validate()">
	</form>
</body>
</html>

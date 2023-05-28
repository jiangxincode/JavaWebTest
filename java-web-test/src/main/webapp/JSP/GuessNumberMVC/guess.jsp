<%@ page contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>猜数字</title>
	</head>
	<body>
${msg } 你已经猜了${guessTimes }次。本游戏共开了${newGameCnt }局。<a href="<%=request.getContextPath() %>/numberGuess.mvc?method:newGame">新游戏</a><br/>
<form action="<%=request.getContextPath() %>/numberGuess.mvc" method="get">
请填写1~100的数值
<input type="text" name="guess">${param.guess }
<input name="method:guess" type="submit" value="提交">
</form>
	</body>
</html>

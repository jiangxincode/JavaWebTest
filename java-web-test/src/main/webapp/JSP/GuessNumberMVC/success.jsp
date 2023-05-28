<%@ page contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>猜数字</title>
	</head>
	<body>
恭喜你猜对了。你共猜了${guessTimes }次。
本游戏共开局${newGameCnt }次。
<a href="<%=request.getContextPath() %>/numberGuess.mvc?method:newGame">开始新游戏</a>
<a href="<%=request.getContextPath() %>/numberGuess.mvc?method:gameIndex">回到首页</a>
	</body>
</html>

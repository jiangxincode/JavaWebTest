<%@ page contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>猜数字</title>
	</head>
	<body>
本游戏共开局${newGameCnt==null?0:newGameCnt }次。<a href="<%=request.getContextPath() %>/newGame.mvc">开始新游戏</a>
	</body>
</html>

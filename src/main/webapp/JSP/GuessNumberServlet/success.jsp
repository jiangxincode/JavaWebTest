<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
</head>
<body>
猜对了，你共猜了${guessTimes}次。
本游戏共开了${newGameCnt}次。
<a href="<%=request.getContextPath() %>/GuessNumber?act=newGame">开始新游戏</a>
</body>
</html>
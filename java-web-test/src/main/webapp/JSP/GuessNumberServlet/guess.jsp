<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
</head>
<body>
${msg } 你已经猜了${guessTimes }次。本游戏共开了${newGameCnt }局。<a href="<%=request.getContextPath() %>/GuessNumber?act=newGame">新游戏</a><br/>
<form action="<%=request.getContextPath() %>/GuessNumber" method="get">
请填写1~100的数值
<input type="hidden" name="act" value="guess">
<input type="text" name="input_number">${param.input_number}
<input type="submit" name="btn" value="提交">
</form>
</body>
</html>
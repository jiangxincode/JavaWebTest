<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%
	Integer guess = Integer.parseInt(request
			.getParameter("input_number"));
	Integer random = (Integer) session.getAttribute("random");
	Integer guessTimes = (Integer) session.getAttribute("guessTimes");
	session.setAttribute("guessTimes", ++guessTimes);
	if (guess == random) {
		request.setAttribute("msg", "right");
	} else if (guess >= random) {
		request.setAttribute("msg", "too big");
	} else {
		request.setAttribute("msg", "too small");
	}
%>

<h1>你已经猜了${guessTimes}次了，本游戏共开了${totalVisits}局。</h1>
${msg} <br />
<a href="input.jsp">新游戏</a>
<form action="guess.jsp" method="get">
	输入一个1~100之间的数字 <input id="guess_input" type="text" name="input_number">${param.input_number}
	<input type="submit" value="submit" onclick="return validate()">
</form>
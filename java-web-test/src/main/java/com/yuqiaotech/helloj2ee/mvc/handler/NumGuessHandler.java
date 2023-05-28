package com.yuqiaotech.helloj2ee.mvc.handler;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.yuqiaotech.helloj2ee.mvc.MvcContext;
import com.yuqiaotech.helloj2ee.mvc.MvcServletContext;

public class NumGuessHandler {

	private String guess;
	private String msg;

	public String handle() {
		return "index";
	}

	public String newGame() {
		Random r = new Random();
		Integer i = r.nextInt(100) + 1;
		Map session = MvcContext.getSessionMap();

		session.put("number", i);
		session.put("guessTimes", 0);
		Integer newGameCnt = (Integer) MvcContext.getApplication().getAttribute("newGameCnt");
		if (newGameCnt == null)
			newGameCnt = 0;
		MvcContext.getApplication().setAttribute("newGameCnt", ++newGameCnt);
		return "newGame";
	}

	public String guess() {
		Map session = MvcContext.getSessionMap();
		int guessNum = Integer.parseInt(guess);
		Integer number = (Integer) session.get("number");
		Integer guessTimes = (Integer) session.get("guessTimes");
		if (guessTimes == null)
			guessTimes = 0;
		session.put("guessTimes", ++guessTimes);
		if (guessNum == number) {
			msg = "对了.";
			return "success";
		} else if (guessNum > number) {
			msg = "偏大了.";
		} else {
			msg = "偏小了.";
		}
		return "guessForm";
	}

	public String getGuess() {
		return guess;
	}

	public void setGuess(String guess) {
		this.guess = guess;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static void main(String[] args) {
		Map sessionMap = new HashMap();
		sessionMap.put("number", 9);

		MvcServletContext context = new MvcServletContext();
		context.setSessionMap(sessionMap);
		MvcContext.context.set(context);

		NumGuessHandler h = new NumGuessHandler();
		h.setGuess("7");
		String x = h.guess();
		System.out.println("NumGuessHandler.main()return string=" + x);
		System.out.println("NumGuessHandler.main()msg" + h.getMsg());
		System.out.println("NumGuessHandler.main()guessTimes=" + sessionMap.get("guessTimes"));

		h.setGuess("10");
		x = h.guess();
		System.out.println("NumGuessHandler.main()return string=" + x);
		System.out.println("NumGuessHandler.main()msg" + h.getMsg());
		System.out.println("NumGuessHandler.main()guessTimes=" + sessionMap.get("guessTimes"));

		h.setGuess("9");
		x = h.guess();
		System.out.println("NumGuessHandler.main()return string=" + x);
		System.out.println("NumGuessHandler.main()msg" + h.getMsg());
		System.out.println("NumGuessHandler.main()guessTimes=" + sessionMap.get("guessTimes"));
	}
}

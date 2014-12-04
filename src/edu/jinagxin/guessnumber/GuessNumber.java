package edu.jinagxin.guessnumber;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuessNumber extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String result = null;
		if("guess".equals(act)) {
			result = guess(request,response);
		}else {
			result = newGame(request,response);
		}
		
		String forwardTo;
		if("success".equals(result)) {
			forwardTo = "JSP/GuessNumberServlet/success.jsp";
		} else {
			forwardTo = "JSP/GuessNumberServlet/guess.jsp";
		}
		
		request.getRequestDispatcher(forwardTo).forward(request, response);
	}
	
	private String newGame(HttpServletRequest request, HttpServletResponse responst) {
		Integer random = new Random().nextInt(100)+1;
		request.getSession().setAttribute("random", random);
		request.getSession().setAttribute("guessTimes", 0);
		Integer newGameCnt = (Integer)request.getSession().getServletContext().getAttribute("newGameCnt");
		if(newGameCnt == null)
		{
			newGameCnt = 0;
		}
		request.getSession().getServletContext().setAttribute("newGameCnt", ++newGameCnt);
		return "newGame";
	}
	
	private String guess(HttpServletRequest request, HttpServletResponse response) {
		Integer guess = Integer.parseInt(request.getParameter("input_number"));
		Integer random = (Integer)request.getSession().getAttribute("random");
		Integer guessTimes = (Integer)request.getSession().getAttribute("guessTimes");
		request.getSession().setAttribute("guessTimes", guessTimes);
		
		if(guess == random) {
			request.setAttribute("msg", "right");
			return "success";
		} else if(guess > random) {
			request.setAttribute("msg", "too big");
		} else {
			request.setAttribute("msg", "too small");
		}
		return "failure";
	
	}
}
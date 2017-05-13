package test.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String[] responses = { "Yes", "No", "Maybe", "Later", "It is your call", "Not a chance" };

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reply = generateReply();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML><HEAD><TITLE>Decision Maker</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<H1>Your answer is: '" + reply + "'</H1>");
		out.println("</BODY></HTML>");
	}

	private String generateReply() {
		// randomly pick a response
		int respIndex = new Random().nextInt(responses.length);
		// return the response back to the caller
		return responses[respIndex];
	}

}

package test.test.homework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String[] interest = request.getParameterValues("interest");
		String address = request.getParameter("address");
		String remark = request.getParameter("remark");

		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("sex", sex);
		request.setAttribute("interest", interest);
		request.setAttribute("address", address);
		request.setAttribute("remark", remark);

		request.getRequestDispatcher("/loginResult1.jsp").forward(request, response);
	}
}
package test.test.homework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zl
 * 
 *         TODO 要更改此生成的类型注释的模板，请转至 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
public class ProcessServlet1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Method stub generated by Lomboz
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Method stub generated by Lomboz
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		List<String> list = new ArrayList<String>();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String[] interest = request.getParameterValues("interest");
		String address = request.getParameter("address");
		String remark = request.getParameter("remark");

		if ("".equals(username)) {
			list.add("用户名为空");
		} else if (username.length() < 4) {
			list.add("用户名长度过短");
		} else if (username.length() > 10) {
			list.add("用户名长度过长");
		}

		if ("".equals(password)) {
			list.add("密码为空");
		} else if (password.length() < 4) {
			list.add("密码长度过短");
		} else if (password.length() > 10) {
			list.add("密码长度过长");
		}
		if (null == sex) {
			list.add("性别没有选择");
		}

		if (null == interest) {
			list.add("兴趣至少选择一个");
		} else if (interest.length > 3) {
			list.add("兴趣最多选择三个");
		}

		if ("".equals(remark)) {
			list.add("说明没有填写");
		}

		if (list.isEmpty()) {
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.setAttribute("sex", sex);
			request.setAttribute("interest", interest);
			request.setAttribute("address", address);
			request.setAttribute("remark", remark);

			request.getRequestDispatcher("/loginResult1.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", list);
			request.getRequestDispatcher("/loginError.jsp").forward(request, response);
		}

	}

}
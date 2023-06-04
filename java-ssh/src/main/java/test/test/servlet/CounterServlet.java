package test.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounterServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init invoked");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 获得ServletContext的引用
		ServletContext context = getServletContext();
		// 从ServletContext读取count属性
		Integer count = (Integer) context.getAttribute("count");

		// 如果count属性还没有设置, 那么创建count属性，初始值为0
		// one and add it to the ServletContext
		if (count == null) {
			count = new Integer(0);
			context.setAttribute("count", new Integer(0));
		}

		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>WebCounter</title></head>");
		out.println("<body>");
		// 输出当前的count属性值
		out.println("<p><h1>The current COUNT is : " + count + ".</h1></p>");
		out.println("</body></html>");

		// 创建新的count对象，其值增1
		count = new Integer(count.intValue() + 1);
		// 将新的count属性存储到ServletContext中
		context.setAttribute("count", count);
	}

	public void destroy() {

	}
}
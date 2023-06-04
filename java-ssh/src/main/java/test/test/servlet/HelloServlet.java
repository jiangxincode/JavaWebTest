package test.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet // 第一步： 扩展 HttpServlet 抽象类。
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 第二步：覆盖doGet()方法
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 第三步：获取HTTP 请求中的参数信息
		String clientName = request.getParameter("clientName");
		if (clientName != null) {
			clientName = new String(clientName.getBytes("ISO-8859-1"), "GB2312");
		}

		else {
			clientName = "我的朋友";
		}

		// 第四步：生成 HTTP 响应结果。

		PrintWriter out;
		String title = "HelloServlet";
		String heading1 = "This is output from HelloServlet by doGet:";
		// set content type.
		response.setContentType("text/html;charset=GB2312");
		// write html page.
		out = response.getWriter();
		out.print("<HTML><HEAD><TITLE>" + title + "</TITLE>");
		out.print("</HEAD><BODY>");
		out.print(heading1);
		out.println("<h1><P> " + clientName + " : 您好</h1>");
		out.print("</BODY></HTML>");
		// close out.
		out.close();
	}
}

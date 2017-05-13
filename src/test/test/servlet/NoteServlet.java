package test.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=GB2312";

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>留言薄</title></head>");
		out.println("<body>");

		String username = request.getParameter("username");
		String content = request.getParameter("content");
		if (username != null)
			username = new String(username.getBytes("ISO-8859-1"), "GB2312");
		if (content != null)
			content = new String(content.getBytes("ISO-8859-1"), "GB2312");

		if (content != null && !content.equals(""))
			out.println("<p>" + username + "的留言为：" + content + "</P>");

		out.println(" <FORM  action=" + request.getContextPath() + "/NoteServlet method=POST>");

		out.println("<b>姓名:</b>");
		out.println("<input type=text size=10 name=username ><br>");
		out.println("<b>留言:</b><br>");
		out.println("<textarea name=content rows=5 cols=20  wrap></textarea><br>");
		out.println("<BR>");
		out.println("<input type=submit  value=提交>");
		out.println("</form>");
		out.println("</body></html>");
	}

	public void destroy() {
	}
}
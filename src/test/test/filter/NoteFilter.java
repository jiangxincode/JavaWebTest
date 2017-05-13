package test.test.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class NoteFilter implements Filter {
	private FilterConfig config = null;

	private String blackList = null;

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		blackList = config.getInitParameter("blacklist");
	}

	public void destroy() {
		config = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String username = ((HttpServletRequest) request).getParameter("username");
		if (username != null)
			username = new String(username.getBytes("ISO-8859-1"), "GB2312");
		if (username != null && username.indexOf(blackList) != -1) {
			response.setContentType("text/html;charset=GB2312");
			PrintWriter out = response.getWriter();
			out.println("<html><head></head><body>");
			out.println("<h1>对不起," + username + ",你没有权限留言 </h1>");
			out.println("</body></html>");
			out.flush();
			return;
		}

		long before = System.currentTimeMillis();
		config.getServletContext().log("NoteFilter:before call chain.doFilter()");

		chain.doFilter(request, response);

		config.getServletContext().log("NoteFilter:after call chain.doFilter()");
		long after = System.currentTimeMillis();
		String name = "";
		if (request instanceof HttpServletRequest) {
			name = ((HttpServletRequest) request).getRequestURI();
		}
		config.getServletContext().log("NoteFilter:" + name + ": " + (after - before) + "ms");
	}
}
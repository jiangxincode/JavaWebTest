package com.shengsiyuan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shengsiyuan.bean.User;

public class MyLoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		User user = new User();

		HttpSession session = req.getSession();

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String authority = req.getParameter("authority");

		if ("1".equals(authority))
		{
			// ��¼������ͨ�û�
			if ("zhangsan".equals(username) && "123".equals(password))
			{
				// ���û�����Ϣ���õ�session����
				user.setUsername(username);
				user.setPassword(password);
				user.setAuthority(authority);

				session.setAttribute("user", user);

				req.getRequestDispatcher("filter/index.jsp").forward(req,
						resp);
			}
			else
			{
				resp.sendRedirect("filter/login.jsp?username=" + username
						+ "&authority=" + authority);

				// req.setAttribute("username", username);
				// req.setAttribute("password", password);
				// req.setAttribute("authority", authority);
				//				
				// RequestDispatcher rd =
				// req.getRequestDispatcher("session/login.jsp");
				//				
				// rd.forward(req, resp);
			}
		}

		else if ("2".equals(authority))
		{
			// ��¼����ϵͳ����Ա
			if ("lisi".equals(username) && "456".equals(password))
			{
				user.setUsername(username);
				user.setPassword(password);
				user.setAuthority(authority);

				session.setAttribute("user", user);

				req.getRequestDispatcher("filter/index.jsp").forward(req,
						resp);
			}
			else
			{
				resp.sendRedirect("filter/login.jsp?username=" + username
						+ "&authority=" + authority);

				// req.setAttribute("username", username);
				// req.setAttribute("password", password);
				// req.setAttribute("authority", authority);
				//				
				// RequestDispatcher rd =
				// req.getRequestDispatcher("session/login.jsp");
				//				
				// rd.forward(req, resp);
			}
		}
		// ��¼ʧ��
		else
		{
			resp.sendRedirect("filter/login.jsp?username=" + username
					+ "&authority=" + authority);

			// req.setAttribute("username", username);
			// req.setAttribute("password", password);
			// req.setAttribute("authority", authority);
			//			
			// RequestDispatcher rd =
			// req.getRequestDispatcher("session/login.jsp");
			//			
			// rd.forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		this.doPost(req, resp);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

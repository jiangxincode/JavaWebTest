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
			// 登录的是普通用户
			if ("zhangsan".equals(username) && "123".equals(password))
			{
				// 将用户的信息放置到session当中
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
			// 登录的是系统管理员
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
		// 登录失败
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

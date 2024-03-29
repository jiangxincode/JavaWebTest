package com.shengsiyuan.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.shengsiyuan.bean.User;

public class UpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		// 用户未登录
		if (null == session.getAttribute("user")) {
			resp.sendRedirect("session/login.jsp");
			return;
		}

		User user = (User) session.getAttribute("user");

		if ("1".equals(user.getAuthority())) //普通用户
		{
			System.out.println("失败");
		} else //管理员
		{
			System.out.println("成功");
		}

	}
}

package com.test.action;

import com.opensymphony.xwork2.ActionSupport;
import com.test.service.LoginService;

public class LoginAction extends ActionSupport {
	private String username;

	private String password;

	private LoginService loginService;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	public String execute() throws Exception {
		if (loginService.isLogin(username, password)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}

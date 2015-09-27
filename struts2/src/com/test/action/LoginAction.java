package com.test.action;

public class LoginAction {
	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		System.out.println("setUsername invokded");
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("setPassword invoked");
		this.password = password;
	}

	public String execute() throws Exception {
		return "success";
	}
}

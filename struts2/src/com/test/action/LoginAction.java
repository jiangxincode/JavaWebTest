package com.test.action;

import com.opensymphony.xwork2.ActionSupport;
import com.test.exception.PasswordException;
import com.test.exception.UsernameException;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		if (!"hello".equals(username)) {
			throw new UsernameException("username invalid");
		} else if (!"world".equals(password)) {
			throw new PasswordException("password invalid");
		} else {
			return SUCCESS;
		}
	}

	@Override
	public void validate() {
		// if(null == username || -1 != username.indexOf("hello"))
		// {
		// this.addFieldError("username", "username invalid");
		// }
		//
		// if(null == password || password.length() < 4)
		// {
		// this.addFieldError("password","password invalid");
		// }
	}

}

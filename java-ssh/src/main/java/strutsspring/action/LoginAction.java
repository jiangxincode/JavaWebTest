package strutsspring.action;

import com.opensymphony.xwork2.ActionSupport;

import strutsspring.service.LoginService;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
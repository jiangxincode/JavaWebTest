package com.test.action.user;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.service.UserService;

public class ListUserAction extends ActionSupport {
	private UserService service;

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	@Override
	public String execute() throws Exception {
		Map request = (Map) ActionContext.getContext().get("request");

		request.put("list", this.service.findAll());

		return SUCCESS;
	}
}

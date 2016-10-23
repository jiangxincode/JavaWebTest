package com.sxt.test;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String companyName="尚学堂";

	public String execute() throws Exception {
		System.out.println("TestAction.execute()");
		return SUCCESS;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


}

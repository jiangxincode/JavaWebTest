package edu.jiangxin.freemarker.web;

import com.opensymphony.xwork2.ActionSupport;

public class FreeMarkerAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String companyName="Aloys";

	public String execute() throws Exception {
		System.out.println("FreeMarkerAction.execute()");
		return SUCCESS;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


}

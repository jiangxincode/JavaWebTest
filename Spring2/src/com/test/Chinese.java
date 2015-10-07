package com.test;

public class Chinese implements Person {
	private Tool tool;

	public Tool getTool() {
		return tool;
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	public void work() {
		tool.realWork();
	}

}

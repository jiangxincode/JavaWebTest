package edu.jiangxin.webservice.phoneservice.server;

public class Phone {
	private String name;//操作系统名
	private String owner;//拥有者 
	private int total;//市场占有率
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

}

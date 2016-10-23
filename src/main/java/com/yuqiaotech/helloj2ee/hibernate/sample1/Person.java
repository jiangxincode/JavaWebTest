package com.yuqiaotech.helloj2ee.hibernate.sample1;

import java.util.Set;

public class Person {
	private String pid;
	private String name;
	private int age;
	private Set address;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set getAddress() {
		return address;
	}

	public void setAddress(Set address) {
		this.address = address;
	}

}

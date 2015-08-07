package com.yuqiaotech.helloj2ee.java.annotation;

import java.util.Date;

/**
 * 有公司要求给所有属性都加上注释，我觉着所有可以望文生义的地方都不用加注释，
 * 注释不但加长了代码，造成一定的阅读障碍，而且废话般的注释根本就是浪费生命，浪费写注释的人的生命， 更是浪费读代码的人的生命，看了半天，发现都是废话。
 */
public class User {

	private Long id;
	private String username;
	private String password;
	private String realName;
	private String email;
	private Integer age;
	private Integer gender;
	private Date birthday;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Comment(value = "用户名")
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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * 性别。
	 * 
	 * @return
	 */
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

}

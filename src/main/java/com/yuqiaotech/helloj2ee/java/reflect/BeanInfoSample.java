package com.yuqiaotech.helloj2ee.java.reflect;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * 使用BeanInfo来设置和读取对象的属性。 自省。
 */
public class BeanInfoSample {
	static class User {
		private String username;
		private String password;
		private String gender;

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

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}
	}

	public static void main(String[] args) throws Exception {
		User u = new User();
		u.setUsername("Tom");
		u.setPassword("123");
		u.setGender("male");

		BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
		PropertyDescriptor[] propertyDescriptors = beanInfo
				.getPropertyDescriptors();
		for (PropertyDescriptor pd : propertyDescriptors) {
			String proName = pd.getName();
			Object v = pd.getReadMethod().invoke(u, new Object[]{});
			System.out.println(proName + "=" + v);
		}
	}
}
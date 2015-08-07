package com.yuqiaotech.helloj2ee.test;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.yuqiaotech.helloj2ee.java.annotation.User;

/**
 * 反射的作业。 请google一下commons-beanutils以及 reflectionToString和populate。
 */
public class ReflectTest extends TestCase {

	public String reflectionToString(Object o) {
		// 使用反射完成本函数
		return null;
	}

	/**
	 * 使用反射将Map里的内容填充到指定的对象里。
	 * 
	 * @param data
	 * @return
	 */
	public Object populate(Object o, Map<String, Object> data) {
		return null;
	}

	public void testToStringBuilder() {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("username", "test");
		data.put("realName", "Tom");
		data.put("age", 12);
		data.put("gender", 1);

		User u = new User();
		populate(u, data);

		String str = reflectionToString(u);// 应该返回类似如下字符串:username:test,realName:Tom,age:12,gender:1,xxxxx
		assertTrue(str.contains("username:test"));
		assertTrue(str.contains("realName:Tom"));
		assertTrue(str.contains("age:12"));
		assertTrue(str.contains("gender:1"));

	}
}

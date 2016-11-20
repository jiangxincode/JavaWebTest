package com.shengsiyuan.lesson053;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {
	public static void main(String[] args) {
		Properties p = System.getProperties();

		Set<Object> set = p.keySet();

		for (Iterator<Object> iter = set.iterator(); iter.hasNext();) {
			String key = (String) iter.next();
			String value = p.getProperty(key);

			System.out.println(key + "=" + value);
		}
	}
}

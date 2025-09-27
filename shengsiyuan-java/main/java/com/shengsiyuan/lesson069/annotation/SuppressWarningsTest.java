package com.shengsiyuan.lesson069.annotation;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class show the example of using annotation.
 *
 * @author Jiangxin
 *
 */
public class SuppressWarningsTest {
	@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	public static void main(String[] args) {
		Map map = new TreeMap();

		map.put("hello", new Date());

		System.out.println(map.get("hello"));

		Date date = new Date();

		System.out.println(date.toLocaleString());
	}
}

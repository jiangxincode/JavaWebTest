package com.yuqiaotech.helloj2ee.test;

import junit.framework.TestCase;

/**
 * 排序。
 */
public class SortTest extends TestCase {

	public void testSort() {
		String[] strs = new String[] { "b", "x", "dd", "u", "gx" };
		String[] sortedStrs = sortAsc(strs);
		for (int i = 0; i < sortedStrs.length - 1; i++) {
			boolean lessThen = sortedStrs[i].compareTo(sortedStrs[i + 1]) <= 0;
			assertTrue(lessThen);
		}
	}

	/**
	 * 请补全本方法，返回一个字符串数组，该数组的内容和输入的strs相同，但数组元素按照升序排列。
	 * 
	 * @param strs
	 * @return
	 */
	private String[] sortAsc(String[] strs) {
		return null;
	}
}

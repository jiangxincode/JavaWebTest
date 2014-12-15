package com.yuqiaotech.helloj2ee.test;

import junit.framework.TestCase;
/**
 * 递归。
 */
public class RecursionTest extends TestCase{

	public void testSort(){
		String a = "Able was I ere I saw Elba";
		String b = "Caveat emptor";
		assertTrue(isPalindrome(a));
		assertTrue(!isPalindrome(b));
	}
	/**
	 * 请补全本方法，判断输入的字符串是否是回文。
	 * 所谓回文就是指正向读和反向读是一样的，注意不区分大小写。
	 * 这个可以使用循环来实现，另外也可以使用递归来实现。
	 * @param strs
	 * @return
	 */
	private boolean isPalindrome(String str){
		return false;
	}
}

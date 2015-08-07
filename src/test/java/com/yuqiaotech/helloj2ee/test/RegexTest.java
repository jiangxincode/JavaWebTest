package com.yuqiaotech.helloj2ee.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

/**
 * 正则表达式的练习。
 */
public class RegexTest extends TestCase {

	/**
	 * 正则表达式的应用场合之-URLRewrite。
	 */
	public void testUrlRewrite() {
		String patternStr = "";// 请填写合适的内容
		Pattern pattern = Pattern.compile(patternStr);
		String rewriteTo = "";// 请填写合适的内容
		Matcher matcher = pattern.matcher("/newslist/016");
		assertTrue(matcher.matches());
		String newUrl = matcher.replaceAll(rewriteTo);
		assertTrue("/news_list.jsp?catCode=016".equals(newUrl));
	}

	public void testDateReg() {
		String reg = "\\d{4}-((0?[1-9])|(1[0-2]))$";
		assertTrue(("2012-1").matches(reg));
		assertTrue(("2012-2").matches(reg));
		assertTrue(("2012-9").matches(reg));
		assertTrue(("2012-10").matches(reg));
		assertTrue(("2012-12").matches(reg));
		assertTrue(("2012-01").matches(reg));
		assertTrue(("2012-09").matches(reg));

		assertTrue(!("2012-0").matches(reg));
		assertTrue(!("2012-13").matches(reg));
		assertTrue(!("2012-").matches(reg));
		assertTrue(!("2012-00").matches(reg));
		assertTrue(!("2012-111").matches(reg));
	}
}

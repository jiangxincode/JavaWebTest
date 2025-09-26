/**
 * 2009-8-20
 */
package org.zlex.chapter05_2;

import static org.junit.Assert.*;

import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.UrlBase64;
import org.junit.Test;

/**
 * Base64编码与解码测试类
 *
 * @author 梁栋
 * @version 1.0
 * @since 1.0
 */
public class Base64CoderTest {

	/**
	 * 测试Base64编码与解码
	 */
	@Test
	public final void test() throws Exception {

		String inputStr = "Java加密与解密的艺术";

		System.err.println("原文:\t" + inputStr);

		// 进行Base64编码
		String code = Base64Coder.encode(inputStr);

		System.err.println("编码后:\t" + code);

		// 进行Base64解码
		String outputStr = Base64Coder.decode(code);

		System.err.println("解码后:\t" + outputStr);

		// 验证Base64编码解码一致性
		assertEquals(inputStr, outputStr);

	}

	/**
	 * 演示
	 *
	 * @throws Exception
	 */
	@Test
	public final void demo() throws Exception {
		String str = "Base64 编码";
		System.err.println("原文:\t" + str);
		byte[] input = str.getBytes();

		// Base64编码
		byte[] data = Base64.encode(input);
		System.err.println("编码后:\t" + new String(data));

		// Base64解码
		byte[] output = Base64.decode(data);
		System.err.println("解码后:\t" + new String(output));

	}

	/**
	 * 演示
	 *
	 * @throws Exception
	 */
	@Test
	public final void demo2() throws Exception {
		String str = "Base64 编码";
		System.err.println("原文:\t" + str);
		byte[] input = str.getBytes();

		// Url Base64编码
		byte[] data = UrlBase64.encode(input);
		System.err.println("编码后:\t" + new String(data));

		// Url Base64解码
		byte[] output = UrlBase64.decode(data);
		System.err.println("解码后:\t" + new String(output));
	}
}

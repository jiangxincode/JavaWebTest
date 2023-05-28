/**
 * 2008-6-11
 */
package org.zlex.chapter07_2;

import static org.junit.Assert.*;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

/**
 * DESede安全编码组件校验
 * 
 * @author 梁栋
 * @version 1.0
 */
public class DESedeCoderTest {

	/**
	 * 测试
	 * 
	 * @throws Exception
	 */
	@Test
	public final void test() throws Exception {
		String inputStr = "DESede";
		byte[] inputData = inputStr.getBytes();
		System.err.println("原文:\t" + inputStr);

		// 初始化密钥
		byte[] key = DESedeCoder.initKey();
		System.err.println("密钥:\t" + Base64.encodeBase64String(key));

		// 加密
		inputData = DESedeCoder.encrypt(inputData, key);
		System.err.println("加密后:\t" + Base64.encodeBase64String(inputData));

		// 解密
		byte[] outputData = DESedeCoder.decrypt(inputData, key);

		String outputStr = new String(outputData);
		System.err.println("解密后:\t" + outputStr);

		// 校验
		assertEquals(inputStr, outputStr);
	}
}

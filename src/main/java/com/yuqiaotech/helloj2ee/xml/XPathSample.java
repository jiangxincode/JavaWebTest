package com.yuqiaotech.helloj2ee.xml;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

public class XPathSample {

	/**
	 * XPath
	 *
	 */
	public static void main(String[] args) throws XPathExpressionException, UnsupportedEncodingException {

		String str = "<?xml version=\"1.0\" encoding=\"gbk\"?>\n" + "<list>\n" + "  <node id=\"1\">\n"
				+ "    <name alias=\"李逵\">张三</name>\n" + "    <space>http://wishlife.javaeye.com</space>\n"
				+ "  </node>\n" + "  <node>\n" + "    <name>李四</name>\n"
				+ "    <space>http://user.qzone.qq.com/94611981</space>\n" + "  </node>\n" + "</list>";
		InputStream in = new ByteArrayInputStream(str.getBytes("gbk"));

		String result = XPathFactory.newInstance().newXPath().evaluate("//node[1]/name", new InputSource(in));
		System.out.println(result);

	}
}

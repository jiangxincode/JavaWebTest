package com.yuqiaokeji.helloj2ee.xml;

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
		InputStream in = XPathSample.class.getResourceAsStream("test.xml");

		String result = XPathFactory.newInstance().newXPath().evaluate("//node[1]/name", new InputSource(in));
		System.out.println(result);

	}
}

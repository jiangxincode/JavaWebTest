package com.shengsiyuan.xml.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxTest1 {
	public static void main(String[] args) throws Exception {

		SAXParserFactory factory = SAXParserFactory.newInstance();

		SAXParser parser = factory.newSAXParser();

		parser.parse(SaxTest1.class.getResourceAsStream("student.xml"), new MyHandler());

	}
}

class MyHandler extends DefaultHandler {
	@Override
	public void startDocument() throws SAXException {
		System.out.println("parse began");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("parse finished");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("start element");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("finish element");
	}
}

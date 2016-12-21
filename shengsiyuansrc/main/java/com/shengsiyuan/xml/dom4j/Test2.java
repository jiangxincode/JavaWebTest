package com.shengsiyuan.xml.dom4j;

import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.SAXReader;

public class Test2 {

	public static void main(String[] args) throws Exception {

		SAXReader saxReader = new SAXReader();

		Document doc = saxReader.read(Test2.class.getResourceAsStream("student2.xml"));

		Element root = doc.getRootElement();

		System.out.println("root element: " + root.getName());

		System.out.println(root.elements().size());

		System.out.println(root.elements("hello").size());

		Element first = root.element("hello");
		System.out.println(first.attributeValue("age"));

		for (Iterator<?> iter = root.elementIterator(); iter.hasNext();) {
			Element e = (Element) iter.next();
			System.out.println(e.attributeValue("age"));
		}

		System.out.println("---------------------------");

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		org.w3c.dom.Document document = db.parse(Test2.class.getResourceAsStream("student2.xml"));

		DOMReader domReader = new DOMReader();

		Document d = domReader.read(document);

		Element rootElement = d.getRootElement();
		System.out.println(rootElement.getName());

	}
}

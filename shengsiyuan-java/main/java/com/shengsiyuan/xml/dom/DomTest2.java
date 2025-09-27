package com.shengsiyuan.xml.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomTest2 {
	public static void main(String[] args) throws Exception {


		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = dbf.newDocumentBuilder();

		Document doc = db.parse(DomTest2.class.getResourceAsStream("student.xml"));

		System.out.println(doc.getXmlEncoding());
		System.out.println(doc.getXmlVersion());
		System.out.println(doc.getXmlStandalone());

		Element root = doc.getDocumentElement();
		System.out.println(root.getTagName());

		NodeList list = root.getChildNodes();
		System.out.println(list.getLength());

		for (int i = 0; i < list.getLength(); i++) {
			System.out.println(list.item(i).getNodeName());
		}

		System.out.println("----------------------------------");

		for (int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);

			System.out.println(n.getNodeType() + " : " + n.getNodeValue());
		}

		System.out.println("----------------------------------");

		for (int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);

			System.out.println(n.getTextContent());
		}

		System.out.println("----------------------------------");

		NodeList nodeList = doc.getElementsByTagName("学生");

		for (int i = 0; i < nodeList.getLength(); i++) {
			NamedNodeMap nnm = nodeList.item(i).getAttributes();

			String attrName = nnm.item(0).getNodeName();
			System.out.print(attrName);

			System.out.print("=");

			String attrValue = nnm.item(0).getNodeValue();

			System.out.println(attrValue);
		}

	}
}

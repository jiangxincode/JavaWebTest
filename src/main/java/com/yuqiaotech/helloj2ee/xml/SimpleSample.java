package com.yuqiaotech.helloj2ee.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author YUQIAOTECH
 */
public class SimpleSample {
	static String xmlName = "test.xml";
	static String xlst = "xslt.xsl";
	static String dom4jSaveTo = "temp/result.xml";
	static String xsltSaveTo = "temp/result.html";

	/**
	 * DOM方式
	 */
	public void DOM() {
		long lasting = System.currentTimeMillis();

		try {
			InputStream in = SimpleSample.class.getResourceAsStream(xmlName);
			javax.xml.parsers.DocumentBuilderFactory factory = javax.xml.parsers.DocumentBuilderFactory
					.newInstance();
			javax.xml.parsers.DocumentBuilder builder = factory
					.newDocumentBuilder();
			org.w3c.dom.Document doc = builder.parse(in);
			org.w3c.dom.NodeList nl = doc.getElementsByTagName("node");
			for (int i = 0; i < nl.getLength(); i++) {
				org.w3c.dom.Element ele = (org.w3c.dom.Element) nl.item(i);
				System.out.println("|| Name: |"
						+ ele.getElementsByTagName("name").item(0)
								.getFirstChild().getNodeValue());
				System.out.println("|| Space: |"
						+ ele.getElementsByTagName("space").item(0)
								.getFirstChild().getNodeValue());
				System.out
						.println("-------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("耗时：" + (System.currentTimeMillis() - lasting)
				+ " MS");
	}

	/**
	 * SAX方式
	 */
	class SaxHandler extends org.xml.sax.helpers.DefaultHandler {
		Stack<String> tags = new Stack<String>();
		String name;
		String space;

		public void startElement(String uri, String localName, String qName,
				org.xml.sax.Attributes attrs) {
			if (!tags.empty()) {
				tags.push(qName);
			} else if (qName.equals("node")) {
				tags.push(qName);
			}
		}

		public void characters(char ch[], int start, int length) {
			if (!tags.empty()) {
				String tag = tags.peek();
				if (tag.equals("name")) {
					name = new String(ch, start, length);
				} else if (tag.equals("space")) {
					space = new String(ch, start, length);
				}
			}
		}

		public void endElement(String uri, String localName, String qName) {
			if (!tags.empty()) {
				String tag = tags.pop();
				if ((tags.empty()) && tag.equals("node")) {
					System.out.println("|| Name:  |" + name);
					System.out.println("||Space:  |" + space);
					System.out
							.println("-------------------------------------------------");
				}
			}
		}
	}

	public void SAX() {

		long lasting = System.currentTimeMillis();
		try {
			InputStream in = SimpleSample.class.getResourceAsStream(xmlName);
			javax.xml.parsers.SAXParserFactory sf = javax.xml.parsers.SAXParserFactory
					.newInstance();
			javax.xml.parsers.SAXParser sp = sf.newSAXParser();
			SaxHandler reader = new SaxHandler();
			sp.parse(in, reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("SAX 耗时：" + (System.currentTimeMillis() - lasting)
				+ " MS");
	}

	/**
	 * JDOM方式
	 */
	@SuppressWarnings("unchecked")
	public void JDOM() {
		long lasting = System.currentTimeMillis();
		try {
			org.jdom.input.SAXBuilder builder = new org.jdom.input.SAXBuilder();
			InputStream in = SimpleSample.class.getResourceAsStream(xmlName);
			org.jdom.Document doc = builder.build(in);
			org.jdom.Element foo = doc.getRootElement();
			List<org.jdom.Element> allChildren = foo.getChildren();
			for (int i = 0; i < allChildren.size(); i++) {
				System.out.println("|| Name:  |"
						+ ((org.jdom.Element) allChildren.get(i)).getChild(
								"name").getText());
				System.out.println("||Space:  |"
						+ ((org.jdom.Element) allChildren.get(i)).getChild(
								"space").getText());
				System.out
						.println("-------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("JDOM RUNTIME："
				+ (System.currentTimeMillis() - lasting) + " MS");
	}

	/**
	 * DOM4J方式
	 */
	@SuppressWarnings("unchecked")
	public void DOM4J() {
		long lasting = System.currentTimeMillis();
		try {
			InputStream in = SimpleSample.class.getResourceAsStream(xmlName);
			org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
			org.dom4j.Document doc = reader.read(in); // 注意这里的Document是org.dom4j包下的
			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (Iterator<org.dom4j.Element> i = root.elementIterator("node"); i
					.hasNext();) {
				foo = (org.dom4j.Element) i.next();
				System.out.println("|| Name:  |" + foo.elementText("name"));
				System.out.println("||Space:  |" + foo.elementText("space"));
				System.out
						.println("-------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DOM4J 耗时：" + (System.currentTimeMillis() - lasting)
				+ " MS");
	}

	/**
	 * 调用dom4j的保存方法。
	 * 
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static void saveDocByDom4J() throws org.dom4j.DocumentException,
			IOException {
		Writer out = new OutputStreamWriter(new FileOutputStream(dom4jSaveTo),
				"UTF-8");
		org.dom4j.io.OutputFormat format = org.dom4j.io.OutputFormat
				.createPrettyPrint();
		org.dom4j.io.XMLWriter writer = new org.dom4j.io.XMLWriter(out, format);
		InputStream in = SimpleSample.class.getResourceAsStream(xmlName);
		org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
		org.dom4j.Document doc = reader.read(in);
		writer.write(doc);
		out.close();
	}

	/**
	 * 使用Transformer和xslt。 http://www.ibm.com/developerworks/cn/xml/x-xslt/
	 * 
	 */
	public static void saveByTransformer()
			throws javax.xml.parsers.ParserConfigurationException,
			org.xml.sax.SAXException, IOException {
		try {
			InputStream in = SimpleSample.class.getResourceAsStream(xmlName);
			InputStream inXsl = SimpleSample.class.getResourceAsStream(xlst);
			javax.xml.parsers.DocumentBuilderFactory factory = javax.xml.parsers.DocumentBuilderFactory
					.newInstance();
			javax.xml.parsers.DocumentBuilder builder = factory
					.newDocumentBuilder();
			org.w3c.dom.Document doc = builder.parse(in);
			javax.xml.transform.stream.StreamSource style = new javax.xml.transform.stream.StreamSource(
					inXsl);
			javax.xml.transform.TransformerFactory tFactory = javax.xml.transform.TransformerFactory
					.newInstance();
			javax.xml.transform.Transformer transformer = tFactory
					.newTransformer(style);
			transformer.setOutputProperty(
					javax.xml.transform.OutputKeys.ENCODING, "GBK");
			javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(
					doc);
			javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(
					new File(xsltSaveTo));
			transformer.transform(source, result);
		} catch (javax.xml.transform.TransformerConfigurationException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (javax.xml.transform.TransformerException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static void main(String arge[])
			throws javax.xml.parsers.ParserConfigurationException,
			org.xml.sax.SAXException, IOException, org.dom4j.DocumentException {
		SimpleSample myXML = new SimpleSample();
		System.out.println("=====================DOM=========================");
		myXML.DOM();
		System.out.println("=====================SAX=========================");
		myXML.SAX();
		System.out.println("=====================JDOM========================");
		myXML.JDOM();
		System.out.println("=====================DOM4J=======================");
		myXML.DOM4J();
		System.out
				.println("=====================DOM4J的格式化保存=======================");
		saveDocByDom4J();
		System.out
				.println("=====================Transformer和xslt的使用=======================");
		saveByTransformer();
	}
}

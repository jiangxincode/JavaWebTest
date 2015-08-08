package com.shengsiyuan.xml.dom4j;

import java.io.FileWriter;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class Test3 {
	public static void main(String[] args) throws Exception {
		
		String path = "target/test-classes/com/shengsiyuan/xml/";
		
		Document document = new Document();

		Element root = new Element("联系人列表").setAttribute(new Attribute("公司", "A集团"));

		document.addContent(root);

		Element contactPerson = new Element("联系人");

		root.addContent(contactPerson);

		contactPerson.addContent(new Element("姓名").setText("张三")).addContent(new Element("公司").setText("A公司"))
				.addContent(new Element("电话").setText("021-55556666"))
				.addContent(new Element("地址").addContent(new Element("街道").setText("5街"))
						.addContent(new Element("城市").setText("上海")).addContent(new Element("省份").setText("上海市")));

		XMLOutputter output = new XMLOutputter(Format.getPrettyFormat().setIndent("    ").setEncoding("gbk"));

		output.output(document, new FileWriter(path + "contact.xml"));

	}
}

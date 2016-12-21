package com.shengsiyuan.xml.jdom;

import java.io.FileWriter;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDomTest3 {
	public static void main(String[] args) throws Exception {

		String outputPath = JDomTest3.class.getResource("/").getPath() + "contact.xml";

		Document document = new Document();

		Element root = new Element("联系人列表").setAttribute(new Attribute("公司", "A集团"));

		document.addContent(root);

		Element contactPerson = new Element("联系人");

		root.addContent(contactPerson);

		contactPerson.addContent(new Element("姓名").setText("张三")).addContent(new Element("公司").setText("A公司"))
				.addContent(new Element("电话").setText("021-55556666"))
				.addContent(new Element("地址").addContent(new Element("街道").setText("5街"))
						.addContent(new Element("城市").setText("上海")).addContent(new Element("省份").setText("上海市")));

		XMLOutputter output = new XMLOutputter(Format.getPrettyFormat().setIndent("    ").setEncoding("UTF-8"));

		output.output(document, new FileWriter(outputPath));

	}
}

package edu.jiangxin.xml.jdom;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDomTest2 {
	public static void main(String[] args) throws Exception {

		String inputPath = JDomTest2.class.getResource("jdom.xml").getPath();
		String outputPath = JDomTest2.class.getResource("/").getPath() + "jdom2.xml";

		SAXBuilder builder = new SAXBuilder();

		Document doc = builder.build(new File(inputPath));

		Element element = doc.getRootElement();

		System.out.println(element.getName());

		//element.getChildren("hello");

		Element hello = element.getChild("hello");

		System.out.println(hello.getText());

		List<Attribute> list = hello.getAttributes();

		for (int i = 0; i < list.size(); i++) {
			Attribute attr = (Attribute) list.get(i);

			String attrName = attr.getName();
			String attrValue = attr.getValue();

			System.out.println(attrName + "=" + attrValue);
		}

		hello.removeChild("world");

		XMLOutputter out = new XMLOutputter(Format.getPrettyFormat().setIndent("    "));

		out.output(doc, new FileOutputStream(outputPath));

	}
}

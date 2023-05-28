package com.yuqiaotech.helloj2ee.xml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XSLTSample {
	/**
	 * 使用Transformer和xslt
	 *
	 */
	public static void main(String arge[])
			throws ParserConfigurationException, SAXException, IOException, TransformerException {

		String resultPath = XSLTSample.class.getResource("/").getPath() + "saveByTransformer.html";
		InputStream in = XSLTSample.class.getResourceAsStream("test.xml");
		InputStream inXsl = XSLTSample.class.getResourceAsStream("xslt.xsl");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(in);
		StreamSource style = new StreamSource(inXsl);
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer = tFactory.newTransformer(style);
		transformer.setOutputProperty(OutputKeys.ENCODING, "GBK");
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(resultPath));
		transformer.transform(source, result);

	}
}

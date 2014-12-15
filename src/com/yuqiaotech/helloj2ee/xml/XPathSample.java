package com.yuqiaotech.helloj2ee.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.sun.org.apache.xpath.internal.XPathAPI;
/**
 * http://blog.csdn.net/geekwang/archive/2008/05/25/2480504.aspx 
 * 
 * 我主要是把从绝对路径读取xml换成了从classpath读取。
 * 另外添加了Transformer和xslt，以及XPath的演示，以及相关的一些链接。
 * 
 * 另外可以搜一下jaxp了解这个规范的相关内容。
 * 
 * @author YUQIAOTECH
 *
 */
public class XPathSample  {
  
	//**********************XPath*****************************
	/**
	 * 返回指定的节点。
	 * 
	 * @param topNode
	 * @param xPath
	 * @return
	 */
	public static Node selectSingleNode(Node topNode, String xPath) {
		try {
			return XPathAPI.selectSingleNode(topNode, xPath);
		} catch (TransformerException e) {
			System.out.println(e.getMessage() + " xPath=" + xPath);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * 根据属性名获取属性节点。
	 * 
	 * @param node
	 * @param attributeName
	 * @return
	 */
	public static Node getAttributeNode(Node node, String attributeName) {
		NamedNodeMap namedNodeMap = node.getAttributes();
		return namedNodeMap.getNamedItem(attributeName);
	}

	/**
	 * 几个方法的组合。
	 * 
	 * @param node
	 * @param xPath
	 * @param attributeName
	 * @return
	 */
	public static String getAttributeNodeByXPath(Node node, String xPath,
			String attributeName) {
		Node rtn = null;
		Node selectedNode = selectSingleNode(node, xPath);
		if (selectedNode != null) {
			rtn = getAttributeNode(selectedNode, attributeName);
		}
		if(rtn == null)return null;
		return rtn.getNodeValue();
	}
	/**
	 * http://www.zvon.org/xxl/XPathTutorial/General_chi/examples.html
	 * http://www.ibm.com/developerworks/cn/xml/x-wxxm35.html
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static void XPath() throws ParserConfigurationException, SAXException, IOException{

		String   str   =   
			"<?xml version=\"1.0\" encoding=\"gbk\"?>\n" +
			"<list>\n" + 
			"  <node id=\"1\">\n" + 
			"    <name alias=\"李逵\">张三</name>\n" + 
			"    <space>http://wishlife.javaeye.com</space>\n" + 
			"  </node>\n" + 
			"  <node>\n" + 
			"    <name>李四</name>\n" + 
			"    <space>http://user.qzone.qq.com/94611981</space>\n" + 
			"  </node>\n" + 
			"</list>";
		InputStream in= new ByteArrayInputStream(str.getBytes("gbk"));
        DocumentBuilderFactory factory = DocumentBuilderFactory  
                .newInstance();  
        DocumentBuilder builder = factory.newDocumentBuilder();  
        Document doc = builder.parse(in); 
        String attr = getAttributeNodeByXPath(doc,"//node[1]/name","alias");
        System.out.println("alias="+attr);
        
	}
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		XPath();
	}
}  

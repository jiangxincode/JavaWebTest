package com.yuqiaotech.helloj2ee.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 大体代码是从http://www.javaeye.com/topic/181865抄来的。
 * 下面这个是被广泛抄袭的，关于java里读取xml的概要介绍。
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
public class SimpleSample  {  
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
            DocumentBuilderFactory factory = DocumentBuilderFactory  
                    .newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();  
            Document doc = builder.parse(in); //注意这里的Document是org.w3c.dom包下的
            NodeList nl = doc.getElementsByTagName("node");  
            for (int i = 0; i < nl.getLength(); i++) {  
            	Element ele = (Element) nl.item(i);
                System.out.println("|| Name:  |"  
                        + ele.getFirstChild().getFirstChild().getNodeValue());  
                System.out.println("-------------------------------------------------");            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        System.out.println("耗时："  
                + (System.currentTimeMillis() - lasting) + " MS");  
    }  
  
    class SaxHandler extends DefaultHandler{
    	java.util.Stack tags = new java.util.Stack();  
        public void startElement(String uri, String localName, String qName,  
                Attributes attrs) {  
            tags.push(qName);  
        }  
      
        public void characters(char ch[], int start, int length)  
                throws SAXException {  
            String tag = (String) tags.peek();  
            if (tag.equals("name")) {  
                System.out.println("|| Name:  |" + new String(ch, start, length));  
            }  
            if (tag.equals("space")) {  
                System.out.println("||Space:  |" + new String(ch, start, length));  
            }  
            System.out.println("-------------------------------------------------");  
        }  
    }
  
    /** 
     * SAX方式 
     */  
    public void SAX() {  
  
        long lasting = System.currentTimeMillis();  
        try {  
        	InputStream in = SimpleSample.class.getResourceAsStream(xmlName); 
            SAXParserFactory sf = SAXParserFactory.newInstance();  
            SAXParser sp = sf.newSAXParser();  
            SaxHandler reader = new SaxHandler();  
            sp.parse(in, reader);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        System.out.println("SAX 耗时："  
                + (System.currentTimeMillis() - lasting) + " MS");  
    }  
  

  
    /** 
     * 我懒得去了解JDOM了 :-)。
     * JDOM方式 
     */  
//    public void JDOM() {  
//        long lasting = System.currentTimeMillis();  
//        try {  
//            SAXBuilder builder = new SAXBuilder();  
//            org.jdom.Document doc = builder.build(new File("F:/xmltest.xml"));  
//            Element foo = doc.getRootElement();  
//            List allChildren = foo.getChildren();  
//            for (int i = 0; i < allChildren.size(); i++) {  
//                System.out.println("|| Name:  |"  
//                        + ((Element) allChildren.get(i)).getChild("name")  
//                                .getText());  
//                System.out.println("||Space:  |"  
//                        + ((Element) allChildren.get(i)).getChild("space")  
//                                .getText());  
//                System.out.println("-------------------------------------------------");            }  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        }  
//        System.out.println("JDOM RUNTIME："  
//                + (System.currentTimeMillis() - lasting) + " MS");  
//    }  
  
    /** 
     * DOM4J方式 
     */  
    public void DOM4J() {  
        long lasting = System.currentTimeMillis();  
        try {  
        	InputStream in = SimpleSample.class.getResourceAsStream(xmlName); 
            SAXReader reader = new SAXReader();  
            org.dom4j.Document doc = reader.read(in);  //注意这里的Document是org.dom4j包下的
            org.dom4j.Element root = doc.getRootElement();  
            org.dom4j.Element foo;  
            for (Iterator i = root.elementIterator("node"); i.hasNext();) {  
                foo = (org.dom4j.Element) i.next();  
                System.out.println("|| Name:  |" + foo.elementText("name"));  
                System.out.println("||Space:  |" + foo.elementText("space"));  
                System.out.println("-------------------------------------------------");  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        System.out.println("DOM4J 耗时："  
                + (System.currentTimeMillis() - lasting) + " MS");  
    }
    /**
     * 调用dom4j的保存方法。
     * 
     * @throws DocumentException
     * @throws IOException
     */
    public static void saveDocByDom4J() throws DocumentException, IOException{
        Writer out = new OutputStreamWriter(new FileOutputStream(dom4jSaveTo ),"GBK");
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter( out, format );
    	InputStream in = SimpleSample.class.getResourceAsStream(xmlName); 
        SAXReader reader = new SAXReader();  
        org.dom4j.Document doc = reader.read(in);  
        writer.write( doc );
        out.close();
    }

    /**
     * 使用Transformer和xslt。
     * http://www.ibm.com/developerworks/cn/xml/x-xslt/
     * 
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
	public static void saveByTransformer() throws ParserConfigurationException, SAXException, IOException {
		try {
			InputStream in = SimpleSample.class.getResourceAsStream(xmlName); 
			InputStream inXsl = SimpleSample.class.getResourceAsStream(xlst); 
	        DocumentBuilderFactory factory = DocumentBuilderFactory  
	                .newInstance();  
	        DocumentBuilder builder = factory.newDocumentBuilder();  
	        Document doc = builder.parse(in); 
	        StreamSource style = new StreamSource(inXsl); 
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer(style);
			transformer.setOutputProperty(OutputKeys.ENCODING, "GBK");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(xsltSaveTo));
			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (TransformerException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

    public static void main(String arge[]) throws ParserConfigurationException, SAXException, IOException, DocumentException {  
        SimpleSample myXML = new SimpleSample();  
        System.out.println("=====================DOM=========================");  
        myXML.DOM();  
        System.out.println("=====================SAX=========================");  
        myXML.SAX();  
        //System.out.println("=====================JDOM========================");  
        //myXML.JDOM();  
        System.out.println("=====================DOM4J=======================");  
        myXML.DOM4J();  
        System.out.println("=====================DOM4J的格式化保存=======================");   
        saveDocByDom4J();
        System.out.println("=====================Transformer和xslt的使用=======================");  
        saveByTransformer();
    }  
}  

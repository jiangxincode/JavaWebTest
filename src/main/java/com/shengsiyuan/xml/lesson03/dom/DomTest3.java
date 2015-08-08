package com.shengsiyuan.xml.lesson03.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * ʹ�õݹ��������������һ��xml�ĵ����ҽ��������������������
 * @author zhanglong
 *
 */
public class DomTest3
{
	public static void main(String[] args) throws Exception
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document doc = db.parse(new File("student.xml"));
		//��ø�Ԫ�ؽ��
		Element root = doc.getDocumentElement();
		
		parseElement(root);
	}
	
	private static void parseElement(Element element)
	{
		String tagName = element.getNodeName();
		
		NodeList children = element.getChildNodes();
		
		System.out.print("<" + tagName);
		
		//elementԪ�ص��������������ɵ�NamedNodeMap������Ҫ��������ж�
		NamedNodeMap map = element.getAttributes();
		
		//�����Ԫ�ش�������
		if(null != map)
		{
			for(int i = 0; i < map.getLength(); i++)
			{
				//��ø�Ԫ�ص�ÿһ������
				Attr attr = (Attr)map.item(i);
				
				String attrName = attr.getName();
				String attrValue = attr.getValue();
				
				System.out.print(" " + attrName + "=\"" + attrValue + "\"");
			}
		}
		
		System.out.print(">");
		
		for(int i = 0; i < children.getLength(); i++)
		{
			Node node = children.item(i);
			//��ý�������
			short nodeType = node.getNodeType();
			
			if(nodeType == Node.ELEMENT_NODE)
			{
				//��Ԫ�أ������ݹ�
				parseElement((Element)node);
			}
			else if(nodeType == Node.TEXT_NODE)
			{
				//�ݹ����
				System.out.print(node.getNodeValue());
			}
			else if(nodeType == Node.COMMENT_NODE)
			{
				System.out.print("<!--");
				
				Comment comment = (Comment)node;
				
				//ע������
				String data = comment.getData();
				
				System.out.print(data);
				
				System.out.print("-->");
			}
		}
		
		System.out.print("</" + tagName + ">");
	}
}

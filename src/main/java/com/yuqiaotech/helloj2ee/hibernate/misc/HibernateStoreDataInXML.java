package com.yuqiaotech.helloj2ee.hibernate.misc;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.hibernate.EntityMode;
import org.hibernate.Session;

import com.yuqiaotech.helloj2ee.hibernate.HibernateUtil;

public class HibernateStoreDataInXML {
	static String dataPath = "d:/data.xml";

	public static void exportData() {
		// First unit of work
		Session session = HibernateUtil.getSessionFactory().openSession();
		Session dom4jSession = session.getSession(EntityMode.DOM4J);
		List<Element> l = dom4jSession.createQuery("from User").list();
		// Element userXML =
		// (Element) dom4jSession.load(User.class, 1l);
		try {
			OutputStream os = new DataOutputStream(new FileOutputStream(new File(dataPath)));
			os.write("<root>".getBytes());
			// OutputStream os = System.out;
			for (Element userXML : l) {
				OutputFormat format = OutputFormat.createPrettyPrint();
				XMLWriter writer = new XMLWriter(os, format);
				writer.write(userXML);
			}
			os.write("</root>".getBytes());
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		System.out.println();
		// Shutting down the application
		HibernateUtil.shutdown();
	}

	public static void importData() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Session dom4jSession = session.getSession(EntityMode.DOM4J);
		InputStream is;
		try {
			is = new FileInputStream(new File(dataPath));
			SAXReader reader = new SAXReader();
			org.dom4j.Document doc = reader.read(is);
			org.dom4j.Element root = doc.getRootElement();
			for (Iterator i = root.elementIterator("User"); i.hasNext();) {
				System.out.println("--------------");
				Element foo = (org.dom4j.Element) i.next();
				dom4jSession.saveOrUpdate(foo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		HibernateUtil.shutdown();

	}

	public static void main(String[] args) {
		exportData();
	}
}

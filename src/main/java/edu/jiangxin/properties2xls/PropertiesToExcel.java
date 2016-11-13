package edu.jiangxin.properties2xls;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class PropertiesToExcel {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void propertiesToExcel(InputStream is, OutputStream os,
			String name) throws Exception {

		Properties pro = new Properties();
		pro.load(is);
		Enumeration<?> e = pro.propertyNames();
		WritableWorkbook wwb = Workbook.createWorkbook(os);
		WritableSheet ws = wwb.createSheet(name, 0);
		int i = 0;
		for (; e.hasMoreElements(); i++) {

			String key = e.nextElement().toString();
			String value = pro.getProperty(key);
			Label label = new Label(0, i, key);
			Label valueLabel = new Label(1, i, value);
			ws.addCell(label);
			ws.addCell(valueLabel);
		}
		wwb.write();
		wwb.close();

	}

}

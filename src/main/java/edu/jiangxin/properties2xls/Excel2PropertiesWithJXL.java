package edu.jiangxin.properties2xls;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Excel2PropertiesWithJXL {

	/**
	 * excel为两列第一列为key,第二列为值
	 */
	public static void excel2Properties(File f, OutputStream os) throws Exception {

		Workbook wk = Workbook.getWorkbook(f);
		Properties pro = new Properties();
		Sheet sh = wk.getSheet(0);

		for (int i = 0;; i++) {
			try {
				pro.setProperty(sh.getCell(0, i).getContents(), sh.getCell(1, i).getContents());
			} catch (ArrayIndexOutOfBoundsException e) {
				break;
			}

		}
		pro.store(os, "");
	}

	public static void properties2Excel(InputStream is, OutputStream os, String name) throws Exception {

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

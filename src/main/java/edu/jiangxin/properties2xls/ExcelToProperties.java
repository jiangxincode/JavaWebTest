package edu.jiangxin.properties2xls;

import java.io.File;
import java.io.OutputStream;
import java.util.Properties;

import jxl.Sheet;
import jxl.Workbook;

public class ExcelToProperties {

	/**
	 * @param args
	 * @excel为两列第一列为key,第二列为值
	 * f为要读入的excel文件
	 * os为输出到文件
	 */
	public static void excelToProperties(File f, OutputStream os)
			throws Exception {

		Workbook wk = Workbook.getWorkbook(f);
		Properties pro = new Properties();
		Sheet sh = wk.getSheet(0);

		for (int i = 0;; i++) {
			try {
				pro.setProperty(sh.getCell(0, i).getContents(), sh
						.getCell(1, i).getContents());
			} catch (ArrayIndexOutOfBoundsException e) {
				break;
			}

		}
		pro.store(os, "");
	}

}

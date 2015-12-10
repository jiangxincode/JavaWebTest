package edu.jiangxin.office;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class PropToExcel {

	Properties properties = new OrderedProperties();
	
	public static final String FILENAME = "default_zh_CN";

	public static void main(String[] args) {

		System.setProperty("file.encoding", "UTF-8");

		PropToExcel readWriteXlsDemo = new PropToExcel();

		readWriteXlsDemo.readProperties(FILENAME + ".properties");

		readWriteXlsDemo.writeToExcel(FILENAME + ".xls");

	}

	private void readProperties(String propertiesFilePath) {

		File propertiesFile = new File(propertiesFilePath);

		if (propertiesFile.isFile()) {
			try {

				FileInputStream fisProp = new FileInputStream(propertiesFile);

				BufferedReader in = new BufferedReader(new InputStreamReader(fisProp, "UTF8"));

				properties.load(in);

				fisProp.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	private void writeToExcel(String excelPath) {
		
		/**
		 * 工作簿
		 */
		HSSFWorkbook workBook = null;
		
		FileOutputStream fosExcel = null;
		
		
		try {
			workBook = new HSSFWorkbook();

			HSSFSheet worksheet = workBook.createSheet("Properties");
		
			HSSFCellStyle cellStyle = workBook.createCellStyle();
			cellStyle.setFillForegroundColor(HSSFColor.GOLD.index);
			cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			
			HSSFRow row = worksheet.createRow((short) 0);

			HSSFCell cell1 = row.createCell(0);
			cell1.setCellValue(new HSSFRichTextString("Keys"));
			cell1.setCellStyle(cellStyle);

			HSSFCell cell2 = row.createCell(1);
			cell2.setCellValue(new HSSFRichTextString("Values"));
			cell2.setCellStyle(cellStyle);

			Enumeration<Object> keysEnum = properties.keys();

			while (keysEnum.hasMoreElements()) {

				String propKey = (String) keysEnum.nextElement();
				String propValue = properties.getProperty(propKey);

				HSSFRow rowOne = worksheet.createRow(worksheet.getLastRowNum() + 1);


				HSSFCell cellZero = rowOne.createCell(0);
				HSSFCell cellOne = rowOne.createCell(1);


				cellZero.setCellValue(new HSSFRichTextString(propKey));
				cellOne.setCellValue(new HSSFRichTextString(propValue));

			}


			fosExcel = new FileOutputStream(new File(excelPath));


			workBook.write(fosExcel);

			fosExcel.flush();
			fosExcel.close();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			
			if(fosExcel != null) {
				try {
					fosExcel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(workBook != null) {
				try {
					workBook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}

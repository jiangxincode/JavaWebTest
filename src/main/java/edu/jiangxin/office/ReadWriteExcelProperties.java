package edu.jiangxin.office;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadWriteExcelProperties {

	HashMap<String, String> properties = new HashMap<String, String>();
	
	//public static final String FILENAME = "default_zh_CN";

	public static void main(String[] args) {

		ReadWriteExcelProperties readWriteExcelProperties = new ReadWriteExcelProperties();
		readWriteExcelProperties.readExcelFile("default_en_US.xls");
		readWriteExcelProperties.writeToPropertiesFile("default.properties");

	}

	public void readExcelFile(String fileName) {

		HSSFCell cell1 = null;
		HSSFCell cell2 = null;

		FileInputStream input = null;
		HSSFWorkbook workBook = null;

		try {

			input = new FileInputStream(new File(fileName));
			workBook = new HSSFWorkbook(input);

			HSSFSheet sheet = workBook.getSheet("Properties");

			Iterator<Row> rowIterator = sheet.rowIterator();

			while (rowIterator.hasNext()) {

				HSSFRow row = (HSSFRow) rowIterator.next();

				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {

					cell1 = (HSSFCell) cellIterator.next();

					String key = cell1.getRichStringCellValue().toString();

					if (!cellIterator.hasNext()) {

						System.out.println("No Such Element");

						String value = "";

						properties.put(key, value);

					} else {
						cell2 = (HSSFCell) cellIterator.next();
						String value = cell2.getRichStringCellValue().toString();

						properties.put(key, value);
					}

				}
			}
		}

		catch (Exception e) {

			System.out.println("No Such Element Exception Occured ..... ");

			e.printStackTrace();

		} finally {

			try {
				workBook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void writeToPropertiesFile(String propertiesPath) {

		Properties props = new Properties();

		File propertiesFile = new File(propertiesPath);

		try {

			FileOutputStream xlsFos = new FileOutputStream(propertiesFile);

			Iterator<String> mapIterator = properties.keySet().iterator();

			while (mapIterator.hasNext()) {

				String key = mapIterator.next().toString();

				String value = properties.get(key);

				props.setProperty(key, value);

			}

			props.store(xlsFos, null);

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}
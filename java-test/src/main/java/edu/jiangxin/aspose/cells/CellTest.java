package edu.jiangxin.aspose.cells;

import java.io.InputStream;

import com.aspose.cells.License;
import com.aspose.cells.Workbook;

/**
 *
 * 由于ASPOSE比较吃内存，操作大一点的文件就会堆溢出，所以请先设置好java虚拟机参数：-Xms512m -Xmx512m(参考值)
 */
public class CellTest {

	public static void main(String[] args) {
		InputStream is = CellTest.class.getClassLoader().getResourceAsStream("\\license.xml");

		License aposeLic = new License();
		try {
			aposeLic.setLicense(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Workbook excel = new Workbook();
			String path = CellTest.class.getResource("/").getPath();
			excel.save(path + "aspose_test.xlsx");
			System.out.println("finish");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

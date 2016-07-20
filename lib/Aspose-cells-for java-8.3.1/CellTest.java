package com.test;

import java.io.InputStream;

import com.aspose.cells.License;
import com.aspose.cells.Workbook;

/**
 * 
 * 由于ASPOSE比较吃内存，操作大一点的文件就会堆溢出，所以请先设置好java虚拟机参数：-Xms512m -Xmx512m(参考值)
 * 如有疑问，请在CSDN下载界面留言
 * 
 * @author Spark
 *
 */
public class CellTest {

    /**
     * 获取license
     * 
     * @return
     */
    public static boolean getLicense() {
        boolean result = false;
        InputStream is = CellTest.class.getClassLoader().getResourceAsStream("\\license.xml");

        License aposeLic = new License();
        try {
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        // 验证License
        if (!getLicense()) {
            return;
        }
        try {
            Workbook excel = new Workbook();
            excel.save("D:\\excel.xlsx");
            System.out.println("操作完成！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

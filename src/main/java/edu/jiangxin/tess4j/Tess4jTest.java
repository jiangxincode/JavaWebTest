package edu.jiangxin.tess4j;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * 验证码识别（图片名即为验证码数字）
 *
 */
public class Tess4jTest {
	public static void main(String[] args) throws TesseractException {
		File root = new File(Tess4jTest.class.getResource("/imgs").getPath());
		ITesseract instance = new Tesseract();

		File[] files = root.listFiles();
		for (File file : files) {
			String result = instance.doOCR(file);
			String fileName = file.toString().substring(file.toString().lastIndexOf("\\") + 1);
			System.out.println("图片名：" + fileName + " 识别结果：" + result);
		}
	}
}
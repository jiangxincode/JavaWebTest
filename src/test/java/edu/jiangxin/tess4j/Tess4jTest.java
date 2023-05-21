package edu.jiangxin.tess4j;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * 验证码识别（图片名即为验证码数字）
 *
 */
public class Tess4jTest {

	@Test
	public void testTess4j() {
		String os = System.getProperty("os.name");
		if (os != null && os.startsWith("Windows")) {
			File root = new File(Tess4jTest.class.getResource("/imgs").getPath());
			ITesseract instance = new Tesseract();
			File[] files = root.listFiles();
			for (File file : files) {
				String result = null;
				try {
					result = StringUtils.replaceAll(instance.doOCR(file), "\n", "");
				} catch (TesseractException e) {
					Assert.fail();
				}
				String fileName = file.toString().substring(file.toString().lastIndexOf("\\") + 1, file.toString().lastIndexOf("."));
				Assert.assertEquals(result, fileName);
			}
		}
	}
}
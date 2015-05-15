package edu.jiangxin.office;
/**
 * POI按行读取word,并去掉属性标签内容：超链接 
 * @author jiangxin
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hwpf.extractor.WordExtractor;

public class RemoveLinks {
	public static void main(String args[]) {
		File mydoc = new File("temp/mydoc.doc");
		readDoc(mydoc);

	}

	public static String readDoc(File file) {
		StringBuffer buffer = new StringBuffer();
		InputStream input = null;
		WordExtractor extractor = null;
		String[] paragraphs = null;
		try {
			input = new FileInputStream(file);
			extractor = new WordExtractor(input);
			paragraphs = extractor.getParagraphText();
			for (String paragraph : paragraphs) {
				//System.out.println(buffer);
				buffer.append(WordExtractor.stripFields(paragraph)).append("\\\r\\\n");
				System.out.println(buffer);
			}
			extractor.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return buffer.toString();
	}
}
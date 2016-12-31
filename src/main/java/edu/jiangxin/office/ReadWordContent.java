package edu.jiangxin.office;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hwpf.extractor.WordExtractor;

/**
 * POI按行读取word
 * @author jiangxin
 */
public class ReadWordContent {
	public static void main(String args[]) {

		StringBuffer buffer = new StringBuffer();
		InputStream input = null;
		WordExtractor extractor = null;
		String[] paragraphs = null;
		try {
			extractor = new WordExtractor(ReadWordContent.class.getResourceAsStream("mydoc.doc"));
			paragraphs = extractor.getParagraphText();
			for (String paragraph : paragraphs) {
				// delete the field except the plain text
				buffer.append(WordExtractor.stripFields(paragraph)).append(System.getProperty("line.separator"));
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

		System.out.println(buffer.toString());
	}

}
package edu.jiangxin.office;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hwpf.extractor.WordExtractor;

import edu.jiangxin.path.GetPath;

/**
 * POI按行读取word
 * @author jiangxin
 */
public class ReadWordContent {
	public static void main(String args[]) {
		File mydoc = new File(GetPath.getTestResourcePathWithPackage(new ReadWordContent()) + "mydoc.doc");
		System.out.println(readDoc(mydoc));
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
				// delete the field except the plain text
				buffer.append(WordExtractor.stripFields(paragraph)).append("\r\n");
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
package edu.jiangxin.aspose.words;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import com.aspose.words.Document;
import com.aspose.words.HeaderFooter;
import com.aspose.words.HeaderFooterType;
import com.aspose.words.License;
import com.aspose.words.Section;
import com.aspose.words.SectionCollection;

public class RemoveWatermark {

	private static void removeWatermarkFromHeader(Section sect, int headerType) throws Exception {
		HeaderFooter header = sect.getHeadersFooters().getByHeaderFooterType(headerType);

		if (header != null) {
			sect.getHeadersFooters().remove(header);
		}
	}

	public static void main(String[] args) {

		// 返回读取指定资源的输入流
		License license = new License();
		InputStream is = null;
		try {
			is = RemoveWatermark.class.getResourceAsStream("license.xml");
			if (is == null)
				throw new RuntimeException(
						"Cannot find licenses file. Please contact wdmsyf@yahoo.com or visit http://sheng.javaeye.com for get more information.");
			license.setLicense(is);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException ex) {
				}
				is = null;
			}
		}
		try {
			Document doc = new Document(RemoveWatermark.class.getResourceAsStream("Test002.doc"));
			SectionCollection sectionColl = doc.getSections();

			Iterator it = sectionColl.iterator();
			while (it.hasNext()) {
				Section sect = (Section) it.next();
				try {
					removeWatermarkFromHeader(sect, HeaderFooterType.HEADER_PRIMARY);
					removeWatermarkFromHeader(sect, HeaderFooterType.HEADER_FIRST);
					removeWatermarkFromHeader(sect, HeaderFooterType.HEADER_EVEN);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			doc.save(RemoveWatermark.class.getResource("/").getPath() + "Test002Finish.doc");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

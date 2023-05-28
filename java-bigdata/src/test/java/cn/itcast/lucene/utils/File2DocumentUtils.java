package cn.itcast.lucene.utils;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;

public class File2DocumentUtils {

	public static Document file2Document(String path) {
		File file = new File(path);
		Document doc = new Document();
		try {
			doc.add(new TextField("name", file.getName(), Field.Store.YES));
			doc.add(new TextField("content", FileUtils.readFileToString(file), Field.Store.YES));
			doc.add(new TextField("size", String.valueOf(file.length()), Field.Store.YES));
			doc.add(new TextField("path", file.getAbsolutePath(), Field.Store.YES));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return doc;
	}

	public static void printDocumentInfo(Document doc) {
		System.out.println("------------------------------");
		System.out.println("name     = " + doc.get("name"));
		System.out.println("content  = " + doc.get("content"));
		System.out.println("size     = " + Long.parseLong(doc.get("size")));
		System.out.println("path     = " + doc.get("path"));
	}

}

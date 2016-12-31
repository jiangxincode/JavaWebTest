package cn.itcast.lucene.utils;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumberTools;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;

@SuppressWarnings("deprecation")
public class File2DocumentUtils {

	public static Document file2Document(String path) {
		File file = new File(path);
		Document doc = new Document();
		try {
			doc.add(new Field("name", file.getName(), Store.YES, Index.ANALYZED));
			doc.add(new Field("content", FileUtils.readFileToString(file), Store.YES, Index.ANALYZED));
			doc.add(new Field("size", NumberTools.longToString(file.length()), Store.YES, Index.NOT_ANALYZED));
			doc.add(new Field("path", file.getAbsolutePath(), Store.YES, Index.NOT_ANALYZED));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return doc;
	}

	public static void printDocumentInfo(Document doc) {
		// Field f = doc.getField("name");
		// f.stringValue();
		System.out.println("------------------------------");
		System.out.println("name     = " + doc.get("name"));
		System.out.println("content  = " + doc.get("content"));
		System.out.println("size     = " + NumberTools.stringToLong(doc.get("size")));
		System.out.println("path     = " + doc.get("path"));
	}

}

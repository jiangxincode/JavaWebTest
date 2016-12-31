package cn.itcast.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import cn.itcast.lucene.utils.File2DocumentUtils;

public class IndexDaoTest {

	static String filePath = IndexDaoTest.class.getResource("I_have_a_dream_en.txt").getPath();
	static String filePath2 = IndexDaoTest.class.getResource("I_have_a_dream_zh.txt").getPath();

	public static void main(String[] args) {

		IndexDao indexDao = new IndexDao();

		Document doc = File2DocumentUtils.file2Document(filePath);
		doc.setBoost(1f);
		indexDao.save(doc);

		Document doc2 = File2DocumentUtils.file2Document(filePath2);
		// doc2.setBoost(1.0f);
		indexDao.save(doc2);

		Term term = new Term("path", filePath);
		indexDao.delete(term);

		term = new Term("path", filePath);
		doc = File2DocumentUtils.file2Document(filePath);
		doc.getField("content").setValue("这是更新后的文件内容");
		indexDao.update(term, doc);

		// String queryString = "marvelous";
		// String queryString = "梦想";
		String queryString = "content:梦想";
		QueryResult qr = indexDao.search(queryString, 0, 10);

		System.out.println("总共有【" + qr.getRecordCount() + "】条匹配结果");
		for (Document d : qr.getRecordList()) {
			File2DocumentUtils.printDocumentInfo(d);
		}

	}

}

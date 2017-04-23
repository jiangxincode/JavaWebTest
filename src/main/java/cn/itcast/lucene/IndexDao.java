package cn.itcast.lucene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.FieldCacheRangeFilter;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

import cn.itcast.lucene.utils.File2DocumentUtils;

public class IndexDao {

	Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_47);
	//Analyzer analyzer = new MMAnalyzer();// 词库分词

	RAMDirectory dir = new RAMDirectory();

	/**
	 * 添加/创建索引
	 */
	public void save(Document doc) {

		IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_47, analyzer);
		IndexWriter indexWriter = null;
		try {
			indexWriter = new IndexWriter(dir, conf);
			indexWriter.addDocument(doc);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				indexWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Term是搜索的最小单位，代表某个 Field 中的一个关键词，如：
	 *
	 * new Term( "title", "lucene" );
	 *
	 * new Term( "id", "5" );
	 *
	 * new Term( "id", UUID );
	 *
	 */
	public void delete(Term term) {
		IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_47, analyzer);
		IndexWriter indexWriter = null;
		try {
			indexWriter = new IndexWriter(dir, conf);
			indexWriter.deleteDocuments(term);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				indexWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 更新索引
	 *
	 * <pre>
	 * indexWriter.deleteDocuments(term);
	 * indexWriter.addDocument(doc);
	 * </pre>
	 */
	public void update(Term term, Document doc) {
		IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_47, analyzer);
		IndexWriter indexWriter = null;
		try {
			indexWriter = new IndexWriter(dir, conf);
			indexWriter.updateDocument(term, doc);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				indexWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * <pre>
	 * totalPage = recordCount / pageSize;
	 * if (recordCount % pageSize &gt; 0)
	 * 	totalPage++;
	 * </pre>
	 *
	 */
	public QueryResult search(String queryString, int firstResult, int maxResults) {
		try {
			// 1，把要搜索的文本解析为 Query
			String[] fields = { "name", "content" };
			Map<String, Float> boosts = new HashMap<String, Float>();
			// boosts.put("name", 3f);
			boosts.put("content", 1.0f); //默认为1.0f

			QueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_47, fields, analyzer, boosts);
			Query query = queryParser.parse(queryString);

			return search(query, firstResult, maxResults);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public QueryResult search(Query query, int firstResult, int maxResults) {
		IndexSearcher indexSearcher = null;

		try {
			IndexReader reader = DirectoryReader.open(dir);
			indexSearcher = new IndexSearcher(reader);
			Filter filter = FieldCacheRangeFilter.newLongRange("size", 0L, 100000L, true, true);

			// 排序
			Sort sort = new Sort();
			sort.setSort(new SortField("size", SortField.Type.LONG)); // 默认为升序
			// sort.setSort(new SortField("size", true));

			TopDocs topDocs = indexSearcher.search(query, filter, 10000, sort);

			int recordCount = topDocs.totalHits;
			List<Document> recordList = new ArrayList<Document>();

			// 准备高亮器
			Formatter formatter = new SimpleHTMLFormatter("<font color='red'>", "</font>");
			Scorer scorer = new QueryScorer(query);
			Highlighter highlighter = new Highlighter(formatter, scorer);

			Fragmenter fragmenter = new SimpleFragmenter(50);
			highlighter.setTextFragmenter(fragmenter);
			// ==============

			// 取出当前页的数据
			int end = Math.min(firstResult + maxResults, topDocs.totalHits);
			for (int i = firstResult; i < end; i++) {
				ScoreDoc scoreDoc = topDocs.scoreDocs[i];

				int docSn = scoreDoc.doc; // 文档内部编号
				Document doc = indexSearcher.doc(docSn); // 根据编号取出相应的文档

				// 返回高亮后的结果，如果当前属性值中没有出现关键字，会返回 null
				String hc = highlighter.getBestFragment(analyzer, "content", doc.get("content"));
				if (hc == null) {
					String content = doc.get("content");
					int endIndex = Math.min(50, content.length());
					hc = content.substring(0, endIndex);// 最多前50个字符
				}
				doc.removeField("content");
				doc.add(new TextField("content", hc, Field.Store.YES));
				recordList.add(doc);
			}

			return new QueryResult(recordCount, recordList);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {

		String filePath = IndexDao.class.getResource("I_have_a_dream_en.txt").getPath();
		String filePath2 = IndexDao.class.getResource("I_have_a_dream_zh.txt").getPath();

		IndexDao indexDao = new IndexDao();

		Document doc = File2DocumentUtils.file2Document(filePath);
		indexDao.save(doc);

		Document doc2 = File2DocumentUtils.file2Document(filePath2);
		indexDao.save(doc2);

		Term term = new Term("path", filePath);
		indexDao.delete(term);

		term = new Term("path", filePath);
		doc = File2DocumentUtils.file2Document(filePath);
		indexDao.update(term, doc);

		String queryString = "梦想";
		// String queryString = "content:dream";
		QueryResult qr = indexDao.search(queryString, 0, 10);

		System.out.println("总共有[" + qr.getRecordCount() + "]条匹配结果");
		for (Document d : qr.getRecordList()) {
			File2DocumentUtils.printDocumentInfo(d);
		}

	}
}

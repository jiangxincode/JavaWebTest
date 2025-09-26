package cn.itcast.lucene.query;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.WildcardQuery;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.lucene.IndexDao;
import cn.itcast.lucene.QueryResult;
import cn.itcast.lucene.utils.File2DocumentUtils;

public class QueryTest {

	IndexDao indexDao = null;

	public void queryAndPrintResult(Query query) {
		System.out.println("对应的查询字符串：" + query);
		QueryResult qr = indexDao.search(query, 0, 100);
		System.out.println("总共有【" + qr.getRecordCount() + "】条匹配结果");
		for (Document doc : qr.getRecordList()) {
			File2DocumentUtils.printDocumentInfo(doc);
		}
	}

	@Before
	public void setUp() throws Exception {
		indexDao = new IndexDao();
		String filePath = IndexDao.class.getResource("I_have_a_dream_en.txt").getPath();
		Document doc = File2DocumentUtils.file2Document(filePath);
		indexDao.save(doc);
	}

	/**
	 * 关键词查询
	 *
	 * name:room
	 */
	@Test
	public void testTermQuery() {
		Term term = new Term("content", "dream");
		Query query = new TermQuery(term);
		queryAndPrintResult(query);
	}

	/**
	 * 范围查询
	 *
	 * 包含边界：size:[0000000000001e TO 000000000000rs]
	 *
	 * 不包含边界：size:{0000000000001e TO 000000000000rs}
	 */
	@Test
	public void testRangeQuery() {
		//Query query = NumericRangeQuery.newLongRange("size", 50L, 100L, false, false);
		Query query = LongPoint.newRangeQuery("size", 500L, 100L);
		queryAndPrintResult(query);
	}

	/**
	 * 通配符查询
	 *
	 * '?' 代表一个字符， '*' 代表0个或多个字符
	 *
	 * name:房*
	 *
	 * name:*o*
	 *
	 * name:roo?
	 */
	@Test
	public void testWildcardQuery() {
		Term term = new Term("name", "roo?");
		// Term term = new Term("name", "ro*"); // 前缀查询 PrefixQuery
		// Term term = new Term("name", "*o*");
		// Term term = new Term("name", "房*");
		Query query = new WildcardQuery(term);

		queryAndPrintResult(query);
	}

	/**
	 * 短语查询
	 *
	 * content:"? 绅士 ? ? 饭店"
	 *
	 * content:"绅士 饭店"~2
	 */
	@Test
	public void testPhraseQuery() {
		PhraseQuery phraseQuery = new PhraseQuery.Builder()
				.add(new Term("content", "绅士"))
				.add(new Term("content", "饭店"))
				.setSlop(2).build();
		// phraseQuery.add(new Term("content", "绅士"), 1);
		// phraseQuery.add(new Term("content", "饭店"), 4);

		queryAndPrintResult(phraseQuery);
	}

	/**
	 * +content:"绅士 饭店"~2 -size:[000000000000dw TO 000000000000rs]
	 *
	 * +content:"绅士 饭店"~2 +size:[000000000000dw TO 000000000000rs]
	 *
	 * content:"绅士 饭店"~2 size:[000000000000dw TO 000000000000rs]
	 *
	 * +content:"绅士 饭店"~2 size:[000000000000dw TO 000000000000rs]
	 */
	@Test
	public void testBooleanQuery() {
		// 条件1
		PhraseQuery query1 = new PhraseQuery.Builder()
				.add(new Term("content", "绅士"))
				.add(new Term("content", "饭店"))
				.setSlop(2).build();

		// 条件2
		Query query2 = LongPoint.newRangeQuery("size", 500L, 1000L);

		// 组合
		BooleanQuery boolQuery = new BooleanQuery.Builder().add(query1, Occur.MUST).add(query2, Occur.MUST_NOT)
				.build();
		queryAndPrintResult(boolQuery);
	}

	@Test
	public void testQueryString() {
		// String queryString = "+content:\"绅士 饭店\"~2 -size:[000000000000dw TO 000000000000rs]";
		// String queryString = "content:\"绅士 饭店\"~2 AND size:[000000000000dw TO 000000000000rs]";
		// String queryString = "content:\"绅士 饭店\"~2 OR size:[000000000000dw TO 000000000000rs]";
		// String queryString = "(content:\"绅士 饭店\"~2 NOT size:[000000000000dw TO 000000000000rs])";
//		String queryString = "-content:\"绅士 饭店\"~2 AND -size:[000000000000dw TO 000000000000rs]";
//		String queryString = "-content:\"绅士 饭店\"~2 OR -size:[000000000000dw TO 000000000000rs]";
		//String queryString = "-content:\"绅士 饭店\"~2 NOT -size:[000000000000dw TO 000000000000rs]";

		QueryResult qr = indexDao.search("dream", 0, 10);
		System.out.println("总共有【" + qr.getRecordCount() + "】条匹配结果");
		for (Document doc : qr.getRecordList()) {
			File2DocumentUtils.printDocumentInfo(doc);
		}
	}

}

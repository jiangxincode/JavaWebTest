package cn.itcast.lucene.helloworld;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import cn.itcast.lucene.utils.File2DocumentUtils;

public class HelloWorld {

	public static void main(String[] args) throws CorruptIndexException, IOException, ParseException {

		String filePath = HelloWorld.class.getResource("/cn/itcast/lucene/I_have_a_dream_en.txt").getPath();
		String indexPath = HelloWorld.class.getResource("").getPath();

		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_47);

		// 建立索引 (IndexWriter 是用来操作（增、删、改）索引库的)
		IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_47, analyzer);
		Directory fsDir = FSDirectory.open(new File(indexPath));
		IndexWriter indexWriter = new IndexWriter(fsDir, conf);
		indexWriter.addDocument(File2DocumentUtils.file2Document(filePath));
		indexWriter.close();

		String queryString = "dream";

		// 把要搜索的文本解析为 Query
		String[] fields = { "name", "content" };
		QueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_47, fields, analyzer);
		Query query = queryParser.parse(queryString);

		// 进行查询( IndexSearcher 是用来在索引库中进行查询的)
		IndexReader reader = DirectoryReader.open(fsDir);
		IndexSearcher indexSearcher = new IndexSearcher(reader);
		Filter filter = null;
		TopDocs topDocs = indexSearcher.search(query, filter, 10000);
		System.out.println("总共有【" + topDocs.totalHits + "】条匹配结果");

		// 打印结果
		for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
			int docSn = scoreDoc.doc; // 文档内部编号
			Document doc = indexSearcher.doc(docSn); // 根据编号取出相应的文档
			File2DocumentUtils.printDocumentInfo(doc); // 打印出文档信息
		}

	}
}

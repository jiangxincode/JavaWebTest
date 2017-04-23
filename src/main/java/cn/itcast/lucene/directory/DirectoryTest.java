package cn.itcast.lucene.directory;

import java.io.File;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import cn.itcast.lucene.utils.File2DocumentUtils;

public class DirectoryTest {
	String filePath = DirectoryTest.class.getResource("/cn/itcast/lucene/I_have_a_dream_en.txt").getPath();
	String indexPath = DirectoryTest.class.getResource("").getPath();
	Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_47);

	@Test
	public void test1()throws Exception {
		Directory dir = new RAMDirectory();
		Document doc = File2DocumentUtils.file2Document(filePath);
		IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_47, analyzer);
		IndexWriter indexWriter = new IndexWriter(dir, conf);
		indexWriter.addDocument(doc);
		indexWriter.close();
	}

	@Test
	public void test2() throws Exception{
		Directory fsDir = FSDirectory.open(new File(indexPath));

		// 1，启动时读取
		Directory ramDir = new RAMDirectory(fsDir, null);

		// 运行程序时操作 ramDir
		IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_47, analyzer);
		IndexWriter ramIndexWriter = new IndexWriter(ramDir, conf);
		// 添加 Document
		Document doc = File2DocumentUtils.file2Document(filePath);
		ramIndexWriter.addDocument(doc);
		ramIndexWriter.close();

		// 2，退出时保存
		IndexWriterConfig conf1 = new IndexWriterConfig(Version.LUCENE_47, analyzer);
		IndexWriter fsIndexWriter = new IndexWriter(fsDir, conf1);
		fsIndexWriter.addIndexes(new Directory[]{ramDir});
		fsIndexWriter.close();
	}


	@Test
	public void test3() throws Exception{
		Directory fsDir = FSDirectory.open(new File(indexPath));
		IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_47, analyzer);
		IndexWriter fsIndexWriter = new IndexWriter(fsDir, conf);
		fsIndexWriter.close();
	}
}

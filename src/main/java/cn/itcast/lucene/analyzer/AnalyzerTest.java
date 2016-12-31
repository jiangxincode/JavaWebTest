package cn.itcast.lucene.analyzer;

import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class AnalyzerTest {

	String enText = "I have a dream that my four little children will one day live in a nation where they will not be judged by the color of their skin but by the content of their character.";
	String zhText = "我梦想有一天，我的四个孩子将一个不是以他们的肤色，而是以他们的品格优劣来评价他们的国度里生活。";

	Analyzer en1 = new StandardAnalyzer(); // 单字分词
	Analyzer en2 = new SimpleAnalyzer();

	Analyzer zh1 = new CJKAnalyzer(); // 二分法分词
	// need je-analysis
	// Analyzer zh2 = new MMAnalyzer(); // 词库分词

	@Test
	public void test() throws Exception {
		analyze(en1, enText);
		analyze(en2, enText);

		analyze(zh1, zhText);
		// analyze(zh2, zhText);
	}

	public void analyze(Analyzer analyzer, String text) throws Exception {
		System.out.println("-------------> 分词器：" + analyzer.getClass());
		TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(text));
		Token token = new Token();
		while ((token = tokenStream.next(token)) != null) {
			System.out.println(token);
		}
	}
}

package cn.itcast.lucene.analyzer;

import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;
import org.junit.Test;

public class AnalyzerTest {

	String enText = "I have a dream that my four little children will one day live in a nation where they will not be judged by the color of their skin but by the content of their character.";
	String zhText = "我梦想有一天，我的四个孩子将一个不是以他们的肤色，而是以他们的品格优劣来评价他们的国度里生活。";

	Analyzer en1 = new StandardAnalyzer(Version.LUCENE_47); // 单字分词

	Analyzer zh1 = new CJKAnalyzer(Version.LUCENE_47); // 二分法分词

	@Test
	public void test() throws Exception {
		analyze(en1, enText);
		analyze(zh1, zhText);
	}

	public void analyze(Analyzer analyzer, String text) throws Exception {
		TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(text));
		tokenStream.reset();
		CharTermAttribute cta = tokenStream.addAttribute(CharTermAttribute.class);
        while(tokenStream.incrementToken()){
            System.out.print("[" + cta + "]");
        }
        tokenStream.reset();
        System.out.println();
	}
}

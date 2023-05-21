package edu.jiangxin.office;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class POITest {
    @Test
    public void testWordExtractor() {
        //按行读取word
        StringBuffer buffer = new StringBuffer();
        try (InputStream in = POITest.class.getResourceAsStream("mydoc.doc");
             WordExtractor extractor = new WordExtractor(in)) {
            String[] paragraphs = extractor.getParagraphText();
            for (String paragraph : paragraphs) {
                // delete the field except the plain text
                buffer.append(StringUtils.chomp(WordExtractor.stripFields(paragraph)));
            }
        } catch (Exception e) {
            Assert.fail();
        }
        Assert.assertEquals("hello world", buffer.toString());
    }

}
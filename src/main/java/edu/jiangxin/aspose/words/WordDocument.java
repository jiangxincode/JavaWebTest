package edu.jiangxin.aspose.words;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.aspose.words.BorderType;
import com.aspose.words.CellMerge;
import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.aspose.words.HeaderFooterType;
import com.aspose.words.License;
import com.aspose.words.LineStyle;
import com.aspose.words.ParagraphAlignment;
import com.aspose.words.RelativeHorizontalPosition;
import com.aspose.words.RelativeVerticalPosition;
import com.aspose.words.Section;
import com.aspose.words.StyleIdentifier;
import com.aspose.words.WrapType;

public class WordDocument {
	private Document doc;
	private DocumentBuilder builder;
	private static final String imagePath = WordDocument.class.getResource("japanese-girl.jpg").getPath();

	public WordDocument() throws Exception{
		try {
			doc = new Document();
		} catch (Exception e) {
			e.printStackTrace();
		}
		builder = new DocumentBuilder(doc);
	}

	public static void main(String[] args) throws Exception {
		WordDocument wd = new WordDocument();
		wd.loadLicense();
		wd.createMainPage();
		wd.addHeaderFooter();
		wd.insertTableOfContent();
		wd.createParagraph();
		wd.insertImage();
		wd.insertTable();
		wd.saveDocument();
		System.out.println("文档已生成！");
	}

	 /**
     * 从Classpath（jar文件中）中读取License
     */
    public void loadLicense() {
        // 返回读取指定资源的输入流
        License license = new License();
        InputStream is = null;
        try {
            is = this.getClass().getResourceAsStream("license.xml");
            if (is == null)
                throw new RuntimeException( "Cannot find licenses file. Please contact wdmsyf@yahoo.com or visit http://sheng.javaeye.com for get more information.");
            license.setLicense(is);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                }
                is = null;
            }
        }
    }

	//首页
	public void createMainPage() throws Exception{
		builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.TITLE);
		builder.getFont().setSize(30);
		builder.writeln("北京源硅创新科技有限公司");
		builder.moveToDocumentEnd();
		builder.getFont().clearFormatting();
		builder.getParagraphFormat().clearFormatting();
		builder.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);
		builder.insertField("DATE \\@ yyyy-MM-dd", null);
		addSection();
	}

	//页眉页脚
	public void addHeaderFooter() throws Exception{
		builder.getPageSetup().setDifferentFirstPageHeaderFooter(true);

		builder.moveToHeaderFooter(HeaderFooterType.HEADER_PRIMARY);
	    builder.insertImage((new File(imagePath).getAbsolutePath()),
	    		RelativeHorizontalPosition.PAGE, 10, RelativeVerticalPosition.PAGE, 10, 50, 50, WrapType.THROUGH);
	    builder.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);
		builder.write("北京源硅创新科技有限公司");

		builder.moveToHeaderFooter(HeaderFooterType.FOOTER_PRIMARY);
		builder.getParagraphFormat().getBorders().getByBorderType(BorderType.TOP).setLineStyle(LineStyle.SINGLE);
		builder.getParagraphFormat().setAlignment(ParagraphAlignment.RIGHT);
		builder.write("第");
		builder.insertField("PAGE", null);
		builder.write("页    共");
		builder.insertField("NUMPAGES", null);
		builder.write("页");
	}

	//目录
	public void insertTableOfContent() throws Exception{
		builder.moveToSection(1);
		builder.insertTableOfContents("\\o \"1-3\" \\h \\z \\u");
		addSection();
	}

	//段落
	public void createParagraph() throws Exception{

		builder.moveToSection(2);

		builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_1);
		builder.getFont().setSize(22);
		builder.writeln("一、段落");
		builder.getFont().clearFormatting();

		builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_1);

		builder.getFont().setSize(16);
		builder.writeln("（一）、普通段落");
		builder.getFont().clearFormatting();
		builder.getParagraphFormat().clearFormatting();

		builder.getParagraphFormat().setFirstLineIndent(12);
		builder.writeln("Microsoft Office Word 中的域用作文档中可能会改变的数据的占位符，" +
				"并用于在邮件合并文档中创建套用信函和标签。这些种类的域也称为域代码，" +
				"它们不同于那些用于输入信息的域类型，如在表单上。有关向文档中添加表单域的信息，" +
				"请参阅创建打印表单、创建用户在 Word 中填写的表单或在 Word 中制作核对清单使用特定命令时" +
				"（如插入页码时、插入封面等文档构建基块时或创建目录时），Word 会自动插入域。还可以手动插入域，" +
				"以自动处理文档外观，如合并某个数据源的数据或执行计算。 ");
		builder.writeln("在 Microsoft Office Word 2007 中，很少需要手动插入域，因为内置命令和内容控件" +
				"提供了域为许多 Word 版本提供的大多数功能。在 Word 早" +
				"期版本创建的文档中，比较容易见到域。您可以使用本文中的信息来理解并使用域。");

		builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_1);
		builder.getFont().setSize(16);
		builder.writeln("（二）、设置了字体和颜色的段落");
		builder.getFont().clearFormatting();
		builder.getParagraphFormat().clearFormatting();

		builder.getParagraphFormat().setFirstLineIndent(12);
		builder.getFont().setName("微软雅黑");
		builder.getFont().setColor(Color.red);
		builder.writeln("在删除一个表中的全部数据时，须使用TRUNCATE TABLE 表名;因为用DROP TABLE，DELETE * FROM 表名时" +
				"，TABLESPACE表空间该表的占用空间并未释放，反复几次DROP，DELETE操作后，该TABLESPACE上百兆的空间就被耗光了。 ");
		builder.getFont().clearFormatting();

		builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_1);
		builder.getFont().setSize(16);
		builder.writeln("（三）、设置了粗体、斜体、下划线的段落");
		builder.getFont().clearFormatting();
		builder.getParagraphFormat().clearFormatting();

		builder.getParagraphFormat().setFirstLineIndent(12);
		builder.getFont().setBold(true);
		builder.getFont().setUnderline(1);
		builder.getFont().setItalic(true);
		builder.writeln("在利用import进行数据库重建过程中,有些视图可能会带来问题,因为结构输入的顺序可能造成视图的输入先于它低层次表的输入," +
				"这样建立视图就会失败.要解决这一问题,可采取分两步走的方法:首先输入结构,然后输入数据.");
		builder.getFont().clearFormatting();
		builder.getParagraphFormat().clearFormatting();
		addSection();
	}

	//插入图片
	public void insertImage() throws Exception{
		builder.moveToSection(3);

		builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_1);
		builder.writeln("二、插入图片");
		builder.getParagraphFormat().clearFormatting();

		builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_1);
		builder.getFont().setSize(16);
		builder.writeln("（一）、正常图片");
		builder.getFont().clearFormatting();
		builder.getParagraphFormat().clearFormatting();

		builder.insertImage((new File(imagePath)).getAbsolutePath());
		builder.writeln();

		builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_1);
		builder.getFont().setSize(16);
		builder.writeln("（二）、指定大小的图片");
		builder.getFont().clearFormatting();
		builder.getParagraphFormat().clearFormatting();

		builder.insertImage((new File(imagePath)).getAbsolutePath(), 200, 200);
		builder.writeln();
		addSection();
	}

	//插入表格
	public void insertTable() throws Exception{
		builder.moveToSection(4);

		builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_1);
		builder.writeln("三、插入表格");
		builder.getParagraphFormat().clearFormatting();

		builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_1);
		builder.getFont().setSize(16);
		builder.writeln("（一）、普通表格");
		builder.getFont().clearFormatting();
		builder.getParagraphFormat().clearFormatting();

		builder.startTable();
		builder.getCellFormat().getBorders().setLineStyle(LineStyle.SINGLE);
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 5; j++){
				builder.insertCell();
				builder.write("Row"+(i+1)+"Cell"+(j+1));
			}
			builder.endRow();
		}
		builder.getCellFormat().clearFormatting();
		builder.endTable();

		builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_1);
		builder.getFont().setSize(16);
		builder.writeln("（二）、合并单元格");
		builder.getFont().clearFormatting();
		builder.getParagraphFormat().clearFormatting();

		//坚向合并
		builder.startTable();
		builder.getCellFormat().getBorders().setLineStyle(LineStyle.SINGLE);
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 5; j++){
				builder.insertCell();
				if(i == 0 && j == 0){
					builder.getCellFormat().setVerticalMerge(CellMerge.FIRST);
				}
				else if(i > 0 && j == 0){
					builder.getCellFormat().setVerticalMerge(CellMerge.PREVIOUS);
				}
				else{
					builder.getCellFormat().setVerticalMerge(CellMerge.NONE);
				}
				builder.write("0000");
			}
			builder.endRow();
		}
		builder.endTable();

		builder.insertParagraph();

		builder.getFont().clearFormatting();
		builder.getParagraphFormat().clearFormatting();
		builder.getCellFormat().clearFormatting();

		//横向合并
		builder.startTable();
		builder.getCellFormat().getBorders().setLineStyle(LineStyle.SINGLE);
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 5; j++){
				builder.insertCell();

				if(i == 1 && j == 1){
					builder.getCellFormat().setHorizontalMerge(CellMerge.FIRST);
				}
				else if(i == 1 && j > 0){
					builder.getCellFormat().setHorizontalMerge(CellMerge.PREVIOUS);
				}
				else{
					builder.getCellFormat().setHorizontalMerge(CellMerge.NONE);
				}
				builder.write("0000");
			}
			builder.endRow();
		}
		builder.endTable();

		addSection();

		builder.moveToSection(5);

		builder.getFont().clearFormatting();
		builder.getParagraphFormat().clearFormatting();
		builder.getCellFormat().clearFormatting();

		//横坚合并
		builder.startTable();
		builder.getCellFormat().getBorders().setLineStyle(LineStyle.SINGLE);
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 5; j++){
				builder.insertCell();
				if(i == 0 && j == 0){
					builder.getCellFormat().setVerticalMerge(CellMerge.FIRST);
				}
				else if(i > 0 && j == 0){
					builder.getCellFormat().setHorizontalMerge(CellMerge.NONE);
					builder.getCellFormat().setVerticalMerge(CellMerge.PREVIOUS);
				}
				else if(i == 1 && j == 1){
					builder.getCellFormat().setVerticalMerge(CellMerge.NONE);
					builder.getCellFormat().setHorizontalMerge(CellMerge.FIRST);
				}
				else if(i == 1 && j > 0){
					builder.getCellFormat().setHorizontalMerge(CellMerge.PREVIOUS);
				}
				else if(i == 4 && j == 2){
					builder.getCellFormat().setHorizontalMerge(CellMerge.FIRST);
				}
				else if(i == 4 && j == 3){
					builder.getCellFormat().setHorizontalMerge(CellMerge.PREVIOUS);
				}
				else if(i == 5 && j == 3){
					builder.getCellFormat().setVerticalMerge(CellMerge.PREVIOUS);
				}
				else{
					builder.getCellFormat().setVerticalMerge(CellMerge.NONE);
					builder.getCellFormat().setHorizontalMerge(CellMerge.NONE);
				}
				builder.write("0000");
			}
			builder.endRow();
		}
		builder.endTable();


		builder.insertParagraph();

		builder.getFont().clearFormatting();
		builder.getParagraphFormat().clearFormatting();
		builder.getCellFormat().clearFormatting();

		//单元格图片
		builder.startTable();
		builder.getCellFormat().getBorders().setLineStyle(LineStyle.SINGLE);
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 5; j++){
				builder.insertCell();
				builder.insertImage((new File(imagePath)).getAbsolutePath(), 20, 20);
			}
			builder.endRow();
		}
		builder.endTable();
	}

	public void addSection() throws Exception{
		Section section = new Section(doc);
		doc.getSections().add(section);
	}

	//保存文档
	public void saveDocument() throws Exception{
		doc.updateFields();
		doc.updateTableLayout();
		doc.save(WordDocument.class.getResource("/").getPath() + "Test003Finish.doc");
	}
}

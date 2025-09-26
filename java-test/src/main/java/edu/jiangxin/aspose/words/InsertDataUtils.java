package edu.jiangxin.aspose.words;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;

import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.aspose.words.FormField;
import com.aspose.words.FormFieldCollection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertDataUtils {
	public final Logger log = LogManager.getLogger(InsertDataUtils.class);

	private Document doc;
	private DocumentBuilder builder;

	/**
	 * 提供需要替换的模板或文档的路径
	 *
	 * @param fileName
	 */
	public InsertDataUtils(String fileName) {
		File file = new File(fileName);

		try {
			doc = new Document(file.getAbsolutePath());
			log.debug("载入文档成功!" + fileName);
		} catch (Exception e) {
			log.error("载入文档失败！", e);
		}
		try {
			builder = new DocumentBuilder(doc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据Mark的内容插入数据
	 *
	 * @param mark
	 * @throws Exception
	 */
	public void insertData(Mark mark) throws Exception {
		if (mark.getType() == Mark.TYPE_TEXT) {

			if (mark.getData() == null) {
				log.info("数据为空！");
			}

			// 如果为true则以表单域插入，否则以书签方式插入
			if (mark.isFormField()) {
				insertTextByFormField(mark.getMarkName(), (String) mark.getData());
			} else {
				insertTextByBookmark(mark.getMarkName(), (String) mark.getData());
			}

		} else if (mark.getType() == Mark.TYPE_IMAGE) {

			if (mark.getData() instanceof Image) {

				// 插入图片的类型为 Image对象
				// 将Image对象转换为BufferedImage
				BufferedImage bimg = toBufferedImage((Image) mark.getData());
				insertImageByBookmark(mark.getMarkName(), bimg);

			} else if (mark.getData() instanceof BufferedImage) {
				// 插入图片的类型为BufferedImage对象
				insertImageByBookmark(mark.getMarkName(), (BufferedImage) mark.getData());

			} else if (mark.getData() instanceof String) {
				// 插入图片的类型为String类型（图片路径）
				insertImageByBookmark(mark.getMarkName(), (String) mark.getData());

			} else if (mark.getData() instanceof InputStream) {
				// 插入图片的类型为InputStream对象
				insertImageByBookmark(mark.getMarkName(), (InputStream) mark.getData());
			} else {
				log.info("提供插入图片的类型错误！");
			}

		} else if (mark.getType() == Mark.TYPE_TABLE) {

			if (mark.getTableIndex() > -1) {

				// 在指定表格中插入数据
				insertTableByBookmark(mark.getTableIndex(), mark.getTableData());
			} else {
				// 在指定书签处创建表格并插入数据
				insertTableByBookmark(mark.getMarkName(), mark.getTableData());
			}

		} else {
			log.info("标记名为：" + mark.getMarkName() + "的标记未设置类型！");
		}
	}

	/**
	 * 批量插入
	 *
	 * @param marks
	 *            mark列表
	 * @throws Exception
	 */
	public void insertData(List<Mark> marks) throws Exception {
		insertData(marks.toArray(new Mark[0]));
	}

	/**
	 * 批量插入
	 *
	 * @param marks
	 *            mark数组
	 * @throws Exception
	 */
	public void insertData(Mark[] marks) throws Exception {
		for (Mark m : marks) {
			insertData(m);
		}
	}

	/**
	 * 设置表单域的值（只支持Word2007之前版本的表单域）
	 *
	 * @param formFieldName
	 *            表单域名称
	 * @param text
	 *            表单域值
	 * @throws Exception
	 */
	private void insertTextByFormField(String formFieldName, String text) throws Exception {
		FormFieldCollection fc = doc.getRange().getFormFields();
		FormField ff = fc.get(formFieldName);
		if (ff != null) {
			ff.setTextInputValue(text);
			log.debug("表单域文本插入成功！");
		} else {
			log.debug("根据提供的formFieldName，未找到相应的FormFiled！");
		}
	}

	/**
	 * 批量设置表单域的值（只支持Word2007之前版本的表单域）
	 *
	 * @param map
	 *            key=表单域名称，value=表单域值
	 * @throws Exception
	 */
	private void insertTextByFormField(Map<String, String> map) throws Exception {
		Set<String> keys = map.keySet();
		for (String key : keys) {
			String value = map.get(key);
			insertTextByFormField(key, value);
		}
		log.debug("表单域文本批量插入成功！" + map.toString());
	}

	/**
	 * 在书签后插入文本
	 *
	 * @param bookmarkName
	 *            书签名
	 * @param text
	 *            要插入的文本
	 */
	private void insertTextByBookmark(String bookmarkName, String text) {
		try {
			boolean b = builder.moveToBookmark(bookmarkName);
			if (b) {
				builder.write(text);
				log.debug("文本插入成功！");
			} else {
				log.debug("未找到该书签！");
			}
		} catch (Exception e) {
			log.error("查找书签错误！", e);
		}
	}

	/**
	 * 在多个书签后插入文本
	 *
	 * @param map
	 *            key=书签名，value=文本
	 */
	private void insertTextByBookmark(Map<String, String> map) {
		Set<String> keys = map.keySet();
		for (String key : keys) {
			String value = map.get(key);
			insertTextByBookmark(key, value);
		}
		log.debug("文本已插入！" + map.toString());
	}

	/**
	 * 在指定的书签位置插入图片
	 *
	 * @param bookmarkName
	 *            书签名
	 * @param imagePath
	 *            图片路径
	 */
	private void insertImageByBookmark(String bookmarkName, String imagePath) {
		try {
			boolean b = builder.moveToBookmark(bookmarkName);
			if (b) {
				builder.insertImage(imagePath);
				log.debug("插入图片成功！");
			} else {
				log.debug("未找到该书签！");
			}
		} catch (Exception e) {
			log.error("查找书签错误！", e);
		}
	}

	/**
	 * 在指定的书签位置插入图片
	 *
	 * @param bookmarkName
	 *            书签名
	 * @param image
	 */
	private void insertImageByBookmark(String bookmarkName, BufferedImage image) {
		try {
			boolean b = builder.moveToBookmark(bookmarkName);
			if (b) {
				builder.insertImage(image);
				log.debug("插入图片成功！");
			} else {
				log.debug("未找到该书签！");
			}
		} catch (Exception e) {
			log.error("查找书签错误！", e);
		}
	}

	/**
	 * 在指定的书签位置插入图片
	 *
	 * @param bookmarkName
	 *            书签名
	 * @param stream
	 */
	private void insertImageByBookmark(String bookmarkName, InputStream stream) {
		try {
			boolean b = builder.moveToBookmark(bookmarkName);
			if (b) {
				builder.insertImage(stream);
				log.debug("插入图片成功！");
			} else {
				log.debug("未找到该书签！");
			}
		} catch (Exception e) {
			log.error("查找书签错误！", e);
		}
	}

	/**
	 * 在指定的书签位置插入指定大小的图片
	 *
	 * @param bookmarkName
	 *            书签名
	 * @param imagePath
	 *            图片路径
	 * @param width
	 *            图片宽度
	 * @param height
	 *            图片高度
	 */
	private void insertImageByBookmark(String bookmarkName, String imagePath, double width, double height) {
		try {
			boolean b = builder.moveToBookmark(bookmarkName);
			if (b) {
				builder.insertImage(imagePath, width, height);
				log.debug("插入图片成功！");
			} else {
				log.debug("未找到该书签！");
			}
		} catch (Exception e) {
			log.error("查找书签错误！", e);
		}
	}

	/**
	 * 在指定书签处生成一个指定行和列的表格
	 *
	 * @param bookmarkName
	 *            书签名称
	 * @param data
	 *            数据
	 */
	private void insertTableByBookmark(String bookmarkName, String[][] data) {
		try {
			boolean b = builder.moveToBookmark(bookmarkName);
			if (b) {
				builder.startTable();
				for (int i = 0; i < data.length; i++) {
					for (int j = 0; j < data[i].length; j++) {
						builder.insertCell();
						builder.write(data[i][j]);
					}
					builder.endRow();
				}
				builder.endTable();
				log.debug("插入表格数据成功！");
			} else {
				log.debug("未找到该书签！");
			}
		} catch (Exception e) {
			log.error("查找书签错误！", e);
		}
	}

	/**
	 * 在指定的表格中插入数据
	 *
	 * @param tableIndex
	 *            表格索引（整个文档中第几个表格）
	 * @param data
	 * @throws Exception
	 */
	private void insertTableByBookmark(int tableIndex, String[][] data) throws Exception {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				builder.moveToCell(tableIndex, i, j, 0);
				builder.write(data[i][j]);
			}
		}
		log.debug("插入表格数据成功！");
	}

	/**
	 * 保存文档
	 *
	 * @param fileName
	 *            文档路径
	 */
	public void save(String fileName) {
		try {
			doc.save(fileName);
			log.debug("保存文档成功！" + fileName);
		} catch (Exception e) {
			log.error("文档保存失败！", e);
		}
	}

	/**
	 * 将image类型转换为BufferedImage类型
	 */
	private BufferedImage toBufferedImage(Image image) {
		if (image instanceof BufferedImage) {
			return (BufferedImage) image;
		}

		// This code ensures that all the pixels in the image are loaded
		image = new ImageIcon(image).getImage();

		// Create a buffered image with a format that's compatible with the
		// screen
		BufferedImage bimage = null;
		int type = BufferedImage.TYPE_INT_RGB;
		bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);

		// Copy image to buffered image
		Graphics g = bimage.createGraphics();

		// Paint the image onto the buffered image
		g.drawImage(image, 0, 0, null);
		g.dispose();

		return bimage;
	}

	public static void main(String[] args) throws Exception {
		Image image = Toolkit.getDefaultToolkit()
				.getImage(InsertDataUtils.class.getResource("japanese-girl.jpg").getPath());
		Mark imageMark = new Mark();
		imageMark.setMarkName("image");
		imageMark.setData(image);
		imageMark.setType(Mark.TYPE_IMAGE);

		String[][] strs = { { "1", "2", "3" }, { "4", "5" } };
		Mark tableMark = new Mark();
		tableMark.setMarkName("table");
		tableMark.setTableData(strs);
		tableMark.setTableIndex(0);
		tableMark.setType(Mark.TYPE_TABLE);

		InsertDataUtils util = new InsertDataUtils(InsertDataUtils.class.getResource("Test001.doc").getPath());
		util.insertData(imageMark);
		util.insertData(tableMark);
		util.save(InsertDataUtils.class.getResource("/").getPath() + "Test001Finish.doc");
	}

}

class Mark {
	/** 设置要插入的对象为：文本类型 */
	public final static int TYPE_TEXT = 0;
	/** 设置要插入的对象为：图片类型 */
	public final static int TYPE_IMAGE = 1;
	/** 设置要插入的对象为：表格类型 */
	public final static int TYPE_TABLE = 2;

	private String markName;
	private Object data;
	private String[][] tableData;
	private int type = -1;
	private int tableIndex = -1;
	private boolean isFormField;

	public String getMarkName() {
		return markName;
	}

	/**
	 * 标记名称：可以是表单域名或书签名
	 *
	 * @param markName
	 */
	public void setMarkName(String markName) {
		this.markName = markName;
	}

	public Object getData() {
		return data;
	}

	/**
	 * 如果插入文本，则是字符串 如果插入图片，可以是图片路径，可以是Image或BufferredImage对象，可以是InputStream流。
	 *
	 * @param data
	 */
	public void setData(Object data) {
		this.data = data;
	}

	public int getType() {
		return type;
	}

	/**
	 * 类型：TYPE_TEXT,TYPE_IMAGE,TYPE_TABLE
	 *
	 * @param type
	 */
	public void setType(int type) {
		this.type = type;
	}

	public boolean isFormField() {
		return isFormField;
	}

	/**
	 * 是否从表单域插入，一般插入文本时可以设置此方法
	 *
	 * @param isFormField
	 */
	public void setFormField(boolean isFormField) {
		this.isFormField = isFormField;
	}

	/**
	 * 表格索引，最小从0开始，如果要从一个已有的表格插入数据，需要设置此方法
	 *
	 * @param tableIndex
	 */
	public void setTableIndex(int tableIndex) {
		this.tableIndex = tableIndex;
	}

	public int getTableIndex() {
		return tableIndex;
	}

	/**
	 * 表格数据，如果type设置为TYPE_TABLE，这个必须设置
	 *
	 * @param tableData
	 */
	public void setTableData(String[][] tableData) {
		this.tableData = tableData;
	}

	public String[][] getTableData() {
		return tableData;
	}

}

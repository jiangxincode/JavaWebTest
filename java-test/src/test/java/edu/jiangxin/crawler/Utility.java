package edu.jiangxin.crawler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utility {

	private static Logger m_debug = LogManager.getLogger(Utility.class);

	/**
	 * 从content提取begin之后，end之前的字符串 注意，如果begin没出现，会返回null, 如果end没出现则一直读字符串末尾
	 * 
	 * @param content
	 * @param begin
	 *            如果为null，则从第0个字符开始（包括第0个字符)
	 * @param end
	 *            如果为null，则一直读取到字符串结尾
	 * @return
	 */
	public static String GetSubString(String content, String begin, String end) {
		if (content == null) {
			return null;
		}

		int startIndex;
		if (begin == null) {
			startIndex = 0;
		} else {
			startIndex = content.indexOf(begin);
			if (startIndex == -1)
				return null;
			else
				startIndex += begin.length();
		}

		if (end != null) {
			int endIndex = content.indexOf(end, startIndex);
			if (endIndex == -1)
				return content.substring(startIndex);
			else
				return content.substring(startIndex, endIndex);
		} else {
			return content.substring(startIndex);
		}
	}

	// 保存网页
	public static boolean SavePage(byte[] bytes, String content, String savePath) {
		String name = Utility.GetSubString(content, "<title>", "</title>"); // 提取标题名，作为保存时的文件名
		if (name != null)
			name = name.trim() + ".html";
		else
			return false;

		name = FixFileName(name);
		File tmpFile = new File(savePath, name);
		try {
			FileUtils.createParentDirectories(tmpFile);
			tmpFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(tmpFile);
			fos.write(bytes);
			fos.close();
		} catch (FileNotFoundException e) {
			m_debug.debug("无法建立文件名为\"" + name + "\"的文件");
			return false;
		} catch (IOException e) {
			m_debug.debug("IOException: " + tmpFile.getAbsolutePath(), e);
			return false;
		}

		return true;
	}

	// 去掉文件名中的非法字符
	public static String FixFileName(String name) {
		String res = "";
		for (char c : name.toCharArray()) {
			if ("/\\:*?\"<>|".contains("" + c)) {
				res += " ";
			} else {
				res += c;
			}
		}
		return res;
	}

	public static String ToStandardTime(int second) {
		if (second < 60)
			return second + "s";

		int min = second / 60;
		second %= 60;
		if (min < 60)
			return min + "m" + second + "s";

		int hour = min / 60;
		min %= 60;
		return hour + "h" + min + "m" + second + "s";
	}
}

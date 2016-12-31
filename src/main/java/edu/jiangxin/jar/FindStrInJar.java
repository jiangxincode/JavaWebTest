package edu.jiangxin.jar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * 寻找指定路径下jar包中含特定字符串的文件
 *
 */
public class FindStrInJar {

	private static final Logger LOGGER = Logger.getLogger(FindStrInJar.class);

	public static List<String> find(String dir, boolean recurse, String condition) {
		ArrayList<String> jarFiles = new ArrayList<String>();
		try {
			File d = new File(dir);
			if (!d.isDirectory()) {
				return null;
			}
			File[] files = d.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (recurse && files[i].isDirectory()) {
					find(files[i].getAbsolutePath(), true, condition);
				} else {
					String filename = files[i].getAbsolutePath();
					if (filename.endsWith(".jar") || filename.endsWith(".zip")) {
						ZipFile zip = new ZipFile(filename);
						Enumeration<?> entries = zip.entries();
						while (entries.hasMoreElements()) {
							ZipEntry entry = (ZipEntry) entries.nextElement();

							String thisClassName = new StringBuffer(entry.getName().replace("/", ".")).toString();

							if (StringUtils.endsWithAny(thisClassName, ".class", ".xml", ".properties", "txt")) {

								BufferedReader r = new BufferedReader(new InputStreamReader(zip.getInputStream(entry)));
								while (r.read() != -1) {
									String tempStr = r.readLine();
									if (null != tempStr && tempStr.indexOf(condition) > -1) {
										jarFiles.add(filename + "  --->  " + thisClassName);
										break;
									}
								}
							} else {

							}

						}

						zip.close();
					} else if (StringUtils.endsWithAny(filename, ".sh", ".xml", ".properties")) {

						findStrInPlainText(files[i], condition);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jarFiles;
	}

	private static int findStrInPlainText(File filename, String findStr) throws IOException {

		int count = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));

		while (br.read() != -1) {
			String tempStr = br.readLine();
			if (null != tempStr && tempStr.indexOf(findStr) > -1) {
				LOGGER.info(filename.getAbsolutePath());
				count++;
			}
		}
		br.close();

		return count;

	}

	public static void main(String[] args) {
		String path = FindStrInJar.class.getResource("").getPath();

		List<String> jarFiles = FindStrInJar.find(path, true, "isChinese");
		if (jarFiles.size() == 0) {
			System.out.println("Not Found");
		} else {
			for (int i = 0; i < jarFiles.size(); i++) {
				System.out.println(jarFiles.get(i));
			}
		}
	}

}

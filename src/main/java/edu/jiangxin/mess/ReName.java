package edu.jiangxin.mess;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.zlex.chapter05_2.Base64Coder;

/**
 * 文件重命名
 *
 * @author jiangxin
 */
public class ReName {
	public static void encryptFileName(String dir) throws Exception {

		File srcDirFile = new File(dir);
		File[] files = srcDirFile.listFiles();

		File recoder = new File("d:/temp/encryptFile.txt");

		StringBuilder sb = new StringBuilder();


		for (File file : files) {
			if (file.isDirectory()) {
				continue;
			}
			String oldName = file.getName();
			String newName = Base64Coder.encode(oldName);
			boolean result = file.renameTo(new File(file.getParent() + File.separator + newName.substring(0, 10)));
			sb.append("oldName: " + oldName + "\n" + "newName: " + newName + "\n" + result + "\n");

		}
		FileUtils.writeStringToFile(recoder, sb.toString());
	}

	public static void reName(String srcDirString, String desDirString) throws Exception {

		File srcDirFile = new File(srcDirString);
		File[] files = srcDirFile.listFiles();

		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i].getName());
			// String temp = srcDirFile.getAbsolutePath().toString() +
			// File.separator + i + encode(files[i].getName());
			String temp = Base64Coder.encode(files[i].getName());
			System.out.println(temp);
			System.out.println(Base64Coder.decode(temp));
			System.out.println();
			/*
			 * boolean flag = files[i].renameTo(new File(temp)); if (flag) {
			 * System.out.println("重命名成功" + (i + 1)); } else {
			 * System.out.println("失败"); }
			 */
		}
	}

	public static void main(String[] args) throws Exception {
		encryptFileName("D:/temp/test");
	}
}
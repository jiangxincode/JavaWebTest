package edu.jiangxin.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class String2BytesUtils {

	public static String readBinFile2String0(String filename) throws IOException {
		StringBuilder sb = new StringBuilder();
		byte[] buff = new byte[1024];

		FileInputStream fis = new FileInputStream(new File(filename));

		int len;
		while ((len = fis.read(buff)) != -1) {
			char[] chars = new char[len];
			for (int i = 0; i < len; i++) {
				chars[i] = (char) buff[i];
			}
			sb.append(chars);
		}
		fis.close();
		return sb.toString();
	}

	public static void writeString2BinFile0(String content, String filename) throws IOException {
		FileOutputStream fos = new FileOutputStream(new File(filename));
		char[] chars = content.toCharArray();
		byte[] buff = new byte[chars.length];
		for (int i = 0; i < chars.length; i++) {
			buff[i] = (byte) chars[i];
		}
		fos.write(buff);
		fos.close();
	}

	public static String readBinFile2String1(String filename) throws IOException {
		StringBuilder sb = new StringBuilder();
		byte[] buff = new byte[1024];

		FileInputStream fis = new FileInputStream(new File(filename));
		while (fis.read(buff) != -1) {
			sb.append(buff);
		}
		fis.close();
		return sb.toString();
	}

	public static void writeString2BinFile1(String content, String filename) throws IOException {
		FileOutputStream fos = new FileOutputStream(new File(filename));
		fos.write(content.getBytes());
		fos.close();
	}

	public static String readBinFile2String2(String filename) throws IOException {
		return FileUtils.readFileToString(new File(filename), "UTF-8");
	}

	public static void writeString2BinFile2(String content, String filename) throws IOException {
		FileUtils.writeStringToFile(new File(filename), content, "UTF-8");
	}

	public static void main(String[] args) throws IOException {
		//只有0可以
		String result = readBinFile2String2(String2BytesUtils.class.getResource("").getPath() + "gpl3-process.pdf");
		System.out.println(result);
		writeString2BinFile2(result, String2BytesUtils.class.getResource("").getPath() + "gpl3-process_new.pdf");
	}

}

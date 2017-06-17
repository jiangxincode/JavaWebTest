package edu.jiangxin.zip4j;

import java.io.File;

import java.util.ArrayList;
import java.util.Collections;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class Zip4jTest {

	/**
	 * 解压加密的压缩文件
	 * @param zipfile
	 * @param dest
	 * @param passwd
	 * @throws ZipException
	 */
	public static void unZip(File zipfile, String dest, String passwd) throws ZipException {
		ZipFile zfile = new ZipFile(zipfile);
		//	        zfile.setFileNameCharset("GBK");//在GBK系统中需要设置
		if (!zfile.isValidZipFile()) {
			throw new ZipException("压缩文件不合法，可能已经损坏！");
		}
		File file = new File(dest);
		if (file.isDirectory() && !file.exists()) {
			file.mkdirs();
		}
		if (zfile.isEncrypted()) {
			zfile.setPassword(passwd.toCharArray());
		}
		zfile.extractAll(dest);
	}

	/**
	 * 压缩文件且加密
	 * @param src
	 * @param dest
	 * @param is
	 * @param passwd
	 */
	public static void zip(String src, String dest, boolean is, String passwd) {
		File srcfile = new File(src);
		//创建目标文件
		String destname = buildDestFileName(srcfile, dest);
		ZipParameters par = new ZipParameters();
		par.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		par.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
		if (passwd != null) {
			par.setEncryptFiles(true);
			par.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
			par.setPassword(passwd.toCharArray());
		}
		try {
			ZipFile zipfile = new ZipFile(destname);
			if (srcfile.isDirectory()) {
				if (!is) {
					File[] listFiles = srcfile.listFiles();
					ArrayList<File> temp = new ArrayList<File>();
					Collections.addAll(temp, listFiles);
					zipfile.addFiles(temp, par);
				}
				zipfile.addFolder(srcfile, par);
			} else {
				zipfile.addFile(srcfile, par);
			}
		} catch (ZipException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 目标文件名称
	 * @param srcfile
	 * @param dest
	 * @return
	 */
	public static String buildDestFileName(File srcfile, String dest) {
		if (dest == null) {//没有给出目标路径时
			if (srcfile.isDirectory()) {
				dest = srcfile.getParent() + File.separator + srcfile.getName() + ".zip";
			} else {
				String filename = srcfile.getName().substring(0, srcfile.getName().lastIndexOf("."));
				dest = srcfile.getParent() + File.separator + filename + ".zip";
			}
		} else {
			createPath(dest);//路径的创建
			if (dest.endsWith(File.separator)) {
				String filename = "";
				if (srcfile.isDirectory()) {
					filename = srcfile.getName();
				} else {
					filename = srcfile.getName().substring(0, srcfile.getName().lastIndexOf("."));
				}
				dest += filename + ".zip";
			}
		}
		return dest;
	}

	/**
	 * 路径创建
	 * @param dest
	 */
	private static void createPath(String dest) {
		File destDir = null;
		if (dest.endsWith(File.separator)) {
			destDir = new File(dest);//给出的是路径时
		} else {
			destDir = new File(dest).getParentFile();
		}
		if (!destDir.exists()) {
			destDir.mkdirs();
		}
	}

	public static void main(String[] args) {

		String src = Zip4jTest.class.getResource("a.txt").getPath();
		String dest = Zip4jTest.class.getResource("").getPath() + "a.zip";
		zip(src, dest, true, "123456");

	}

}

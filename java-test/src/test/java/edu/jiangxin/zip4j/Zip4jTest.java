package edu.jiangxin.zip4j;

import java.io.File;

import java.util.ArrayList;
import java.util.Collections;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import org.junit.Assert;
import org.junit.Test;

public class Zip4jTest {

    /**
     * 解压加密的压缩文件
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
     */
    public static void zip(String src, String dest, boolean is, String passwd) throws ZipException {
        File srcfile = new File(src);
        //创建目标文件
        String destname = buildDestFileName(srcfile, dest);
        ZipParameters par = new ZipParameters();
        par.setCompressionMethod(CompressionMethod.DEFLATE);
        par.setCompressionLevel(CompressionLevel.NORMAL);
        if (passwd != null) {
            par.setEncryptFiles(true);
            par.setEncryptionMethod(EncryptionMethod.ZIP_STANDARD);
        }
        ZipFile zipfile = new ZipFile(destname, passwd.toCharArray());
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
    }

    /**
     * 目标文件名称
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

    @Test
    public void testZip() {
        String src = Zip4jTest.class.getResource("a.txt").getPath();
        String dest = Zip4jTest.class.getResource("").getPath() + "a.zip";
		try {
			zip(src, dest, true, "123456");
		} catch (ZipException e) {
			Assert.fail();
		}
	}

    @Test
    public void testUnZip() {
        String src = Zip4jTest.class.getResource("").getPath() + "a.zip";
		String dest = Zip4jTest.class.getResource("").getPath();
		try {
			unZip(new File(src), dest + File.separator + "unzip", "123456");
		} catch (ZipException e) {
			Assert.fail();
		}
	}

}

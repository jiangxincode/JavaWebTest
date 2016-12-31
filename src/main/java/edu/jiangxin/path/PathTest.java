package edu.jiangxin.path;

import java.io.File;

public class PathTest {

	public static void main(String[] args) {

		System.out.println(System.getProperty("user.dir"));// user.dir指定了当前的路径
		File directory = new File("");// 设定为当前文件夹

		try {
			// 比如当前的路径为 C:\test ：
			directory = new File("abc");
			directory.getCanonicalPath(); // 得到的是C:\test\abc
			directory.getAbsolutePath(); // 得到的是C:\test\abc
			directory.getPath(); // 得到的是abc

			directory = new File(".");
			directory.getCanonicalPath(); // 得到的是C:\test
			directory.getAbsolutePath(); // 得到的是C:\test\.
			directory.getPath(); // 得到的是.

			directory = new File("..");
			directory.getCanonicalPath(); // 得到的是C:\
			directory.getAbsolutePath(); // 得到的是C:\test\..
			directory.getPath(); // 得到的是..

			System.out.println(directory.getCanonicalPath());// 获取标准的路径
			System.out.println(directory.getAbsolutePath());// 获取绝对路径
			System.out.println(directory.getPath());

		} catch (Exception e) {
		}

	}

}

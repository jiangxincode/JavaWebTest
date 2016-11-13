package edu.jiangxin.path;

import java.io.File;

import clojure.main;

public class GetPath {

	/**
	 * 获取maven项目的Main资源文件路径（不含包名，以分隔符结尾）
	 *
	 * @return
	 */
	public static String getMainResourcePath() {
		return "target" + File.separator + "classes" + File.separator;
	}

	/**
	 * 获取maven项目的Test资源文件路径（不含包名，以分隔符结尾）
	 *
	 * @return
	 */
	public static String getTestResourcePath() {
		return "target" + File.separator + "test-classes" + File.separator;
	}

	/**
	 * 获取maven项目的Main资源文件路径（含包名，以分隔符结尾）
	 *
	 * @return
	 */
	public static String getMainResourcePathWithPackage(Object obj) {

		String result = "target" + File.separator + "classes" + File.separator;

		String packageName = obj.getClass().getPackage().getName();

		String[] list = packageName.split("\\.");
		for (int i = 0; i < list.length; i++) {
			result += list[i];
			result += File.separator;
		}

		return result;
	}

	/**
	 * 获取maven项目的Test资源文件路径（含包名，以分隔符结尾）
	 *
	 * @return
	 */
	public static String getTestResourcePathWithPackage(Object obj) {

		String result = "target" + File.separator + "test-classes" + File.separator;

		String packageName = obj.getClass().getPackage().getName();

		String[] list = packageName.split("\\.");
		for (int i = 0; i < list.length; i++) {
			result += list[i];
			result += File.separator;
		}

		return result;
	}

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

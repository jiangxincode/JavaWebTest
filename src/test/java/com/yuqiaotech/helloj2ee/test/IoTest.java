package com.yuqiaotech.helloj2ee.test;

import java.io.File;
import java.io.FilenameFilter;

import junit.framework.TestCase;

public class IoTest extends TestCase {
	/**
	 * 写一段遍历文件夹的程序，一边遍历一边打印。 并使用FilenameFilter，使得程序只打印文件夹以及gif和jpg的文件。
	 */
	public void testIteratorDirectory() {
		String user_home = System.getProperty("user.home");
		System.out.println("user_home=" + user_home);
		File f = new File(user_home
				+ "\\Local Settings\\Temporary Internet Files");
		iterator(f, "");
	}

	/**
	 * 遍历时根据文件夹的深度不同，需要能够缩进打印。 如 a a1 a2 b b1 b11 b2
	 * 
	 * @param f
	 * @param str
	 */
	public static void iterator(File f, String indent) {
		// 完成本函数
	}

	static class FilenameFilterImpl implements FilenameFilter {
		/**
		 * 只有文件夹和gif以及jpg文件是可以通过的。
		 */
		public boolean accept(File dir, String fname) {
			// 完成本函数
			return true;
		}
	}
}

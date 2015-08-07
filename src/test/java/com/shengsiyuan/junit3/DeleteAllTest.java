package com.shengsiyuan.junit3;

import java.io.File;

import com.shengsiyuan.junit3.DeleteAll;

import junit.framework.Assert;
import junit.framework.TestCase;

@SuppressWarnings("deprecation")
public class DeleteAllTest extends TestCase {
	public void testDeleteAll() {
		File file = null;

		try {
			file = new File("test.txt");
			file.createNewFile();

			DeleteAll.deleteAll(file);

		} catch (Exception ex) {
			Assert.fail();
		}

		boolean isExist = file.exists();
		
		//Assert.assertEquals(false, isExist);

		Assert.assertFalse(isExist);
	}

	/**
	 * 
	 * 构造的是一个目录结构，其结构表示如下
	 * 
	 *         d
	 *        / \
	 *       d1 d2
	 *      / \
	 *     s1 s2
	 */
	public void testDeleteAll2() {
		File directory = null;

		try {
			directory = new File("dir");
			directory.mkdir();

			File file1 = new File(directory, "file1.txt");
			File file2 = new File(directory, "file2.txt");

			file1.createNewFile();
			file2.createNewFile();

			File d1 = new File(directory, "d1");
			File d2 = new File(directory, "d2");

			d1.mkdir();
			d2.mkdir();

			File subFile1 = new File(d1, "subFile1.txt");
			File subFile2 = new File(d2, "subFile2.txt");

			subFile1.createNewFile();
			subFile2.createNewFile();

			DeleteAll.deleteAll(directory);
		} catch (Exception ex) {
			Assert.fail();
		}

		Assert.assertNotNull(directory);

		String[] names = directory.list();

		Assert.assertEquals(0, names.length);

		directory.delete();
	}

}

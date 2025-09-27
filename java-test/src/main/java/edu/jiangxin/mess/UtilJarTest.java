package edu.jiangxin.mess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class UtilJarTest {

	UtilJar utilJar = null;

	@Before
	public void setUp() throws Exception {
		utilJar = new UtilJar();
	}

	@Test
	public void testCopyJar() {
		File src = new File(UtilJarTest.class.getResource("KaboomZhihu.jar").getPath());
		File des = new File(UtilJarTest.class.getResource("").getPath() + "KaboomZhihuCopy.jar");
		try {
			utilJar.copyJar(src, des);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUnJar() {
		File src = new File(UtilJarTest.class.getResource("KaboomZhihu.jar").getPath());
		File desDir = new File(UtilJarTest.class.getResource("").getPath() + "KaboomZhihu");
		try {
			utilJar.unJar(src, desDir);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCopyJarByJarFile() {
		File src = new File(UtilJarTest.class.getResource("KaboomZhihu.jar").getPath());
		File des = new File(UtilJarTest.class.getResource("").getPath() + "KaboomZhihuCopy.jar");
		try {
			utilJar.copyJarByJarFile(src, des);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUnJarByJarFile() {
		File src = new File(UtilJarTest.class.getResource("KaboomZhihu.jar").getPath());
		File desDir = new File(UtilJarTest.class.getResource("").getPath() + "KaboomZhihu");
		try {
			utilJar.unJarByJarFile(src, desDir);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

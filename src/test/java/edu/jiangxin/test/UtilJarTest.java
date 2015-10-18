package edu.jiangxin.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import edu.jiangxin.path.GetPath;

public class UtilJarTest {
	
	UtilJar utilJar = null;

	@Before
	public void setUp() throws Exception {
		utilJar = new UtilJar();
	}

	@Test
	public void testCopyJar() {
		File src = new File(GetPath.getTestResourcePathWithPackage(new UtilJarTest()) + "hibernate.jar");
		File des = new File(GetPath.getTestResourcePathWithPackage(new UtilJarTest()) + "hibernateCopy.jar");
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
		File src = new File(GetPath.getTestResourcePathWithPackage(new UtilJarTest()) + "hibernate.jar");
		File desDir = new File(src.getParent() + File.separator + "hibernate");
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
		File src = new File(GetPath.getTestResourcePathWithPackage(new UtilJarTest()) + "hibernate.jar");
		File des = new File(GetPath.getTestResourcePathWithPackage(new UtilJarTest()) + "hibernateCopy.zip");
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
		File src = new File(GetPath.getTestResourcePathWithPackage(new UtilJarTest()) + "hibernate.jar");
		File desDir = new File(src.getParent() + File.separator + "hibernate");
		try {
			utilJar.unJarByJarFile(src, desDir);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

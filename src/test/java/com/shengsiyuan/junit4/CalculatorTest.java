package com.shengsiyuan.junit4;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	private Calculator cal;

	@BeforeClass
	public static void globalInit() {
		System.out.println("globalInit invoked!");
	}

	@AfterClass
	public static void globalDestroy() {
		System.out.println("globalDestroy invoked!");
	}

	@Before
	public void setUp() {
		cal = new Calculator();

		System.out.println("before");
	}

	@After
	public void tearDown() {
		System.out.println("destroy");
	}

	@Test(timeout = 800)
	public void testAdd() {
		int result = cal.add(3, 5);

		assertEquals(8, result);
	}

	@Test
	public void testSubtract() {
		int result = cal.subtract(1, 6);

		assertEquals(-5, result);
	}

	@Test
	public void testMultiply() {
		int result = cal.multiply(5, 9);

		assertEquals(45, result);
	}

	@Test(expected = Exception.class)
	public void testDivide() throws Exception {
		cal.divide(1, 0);
	}

}

package com.shengsiyuan.junit3;

import com.shengsiyuan.junit3.Calculator;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * TestCase
 *
 * junit 3.8У
 * 
 * 1. public 2. void 3.  4. test
 *
 */
@SuppressWarnings("deprecation")
public class CalculatorTest extends TestCase {
	private Calculator cal;

	private int count;

	public CalculatorTest(String name) {
		super(name);
	}

	@Override
	public void setUp() throws Exception {
		System.out.println(++count);

		cal = new Calculator();
	}

	@Override
	public void tearDown() throws Exception {

	}

	public void testAdd() {
		int result = cal.add(1, 2);

		Assert.assertEquals(3, result);
	}

	public void testSubtract() {
		int result = cal.subtract(1, 2);

		Assert.assertEquals(-1, result);
	}

	public void testMultiply() {
		int result = cal.multiply(2, 3);

		Assert.assertEquals(6, result);
	}

	public void testDivide() {
		int result = 0;

		try {
			result = cal.divide(6, 2);
		} catch (Exception e) {
			e.printStackTrace();

			Assert.fail();
		}

		Assert.assertEquals(3, result);
	}

	public void testDivideDivideByZero() {
		Throwable tx = null;

		try {
			cal.divide(6, 0);

			Assert.fail("");
		} catch (Exception ex) {
			tx = ex;
		}

		Assert.assertEquals(Exception.class, tx.getClass());
		Assert.assertEquals("除数不能为0", tx.getMessage());
	}

	public static void main(String[] args) {
		//junit.swingui.TestRunner.run(CalculatorTest.class);
	}

}

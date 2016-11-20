package com.shengsiyuan.junit4;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParametersTest {
	private int expected;

	private int input1;

	private int input2;

	private Calculator cal;

	@SuppressWarnings("rawtypes")
	@Parameters
	public static Collection prepareData() {
		Object[][] object = { { 3, 1, 2 }, { -4, -1, -3 }, { 5, 2, 3 },
				{ 4, -4, 8 } };

		return Arrays.asList(object);
	}

	@Before
	public void setUp() {
		cal = new Calculator();
	}

	public ParametersTest(int expected, int input1, int input2) {
		this.expected = expected;
		this.input1 = input1;
		this.input2 = input2;
	}

	@Test
	public void testAdd() {
		assertEquals(this.expected, cal.add(this.input1, this.input2));
	}
}

package com.shengsiyuan.junit3;

import junit.extensions.RepeatedTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestAll extends TestCase {
	public static Test suite() {
		TestSuite suite = new TestSuite();

		suite.addTestSuite(CalculatorTest.class);
		suite.addTestSuite(LargestTest.class);
		suite.addTestSuite(DeleteAllTest.class);

		suite.addTest(new RepeatedTest(new CalculatorTest("testSubtract"), 20));

		return suite;
	}
}

package com.shengsiyuan.junit4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ CalculatorTest.class, LargestTest.class,
		ParametersTest.class })
public class TestAll {

}

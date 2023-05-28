package edu.jiangxin.drools.example;

import org.drools.RuleBase;
import org.drools.RuleBaseFactory;

public class RuleBaseFacatory {
	private static RuleBase ruleBase;

	public static RuleBase getRuleBase() {
		return null != ruleBase ? ruleBase : RuleBaseFactory.newRuleBase();
	}
}

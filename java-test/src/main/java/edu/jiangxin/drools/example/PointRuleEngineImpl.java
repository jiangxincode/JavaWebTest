package edu.jiangxin.drools.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.drools.RuleBase;
import org.drools.StatefulSession;
import org.drools.compiler.DroolsParserException;
import org.drools.compiler.PackageBuilder;
import org.drools.spi.Activation;

public class PointRuleEngineImpl implements PointRuleEngine {
	private RuleBase ruleBase;

	/*
	 * (non-Javadoc)
	 */
	public void initEngine() {

		System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");
		ruleBase = RuleBaseFacatory.getRuleBase();
		try {
			// 获取测试脚本文件
			List<String> drlFilePath = new ArrayList<String>();
			drlFilePath.add(this.getClass().getResource("addpoint.drl").getPath());
			drlFilePath.add(this.getClass().getResource("subpoint.drl").getPath());

			// 装载测试脚本文件
			List<Reader> readers = new ArrayList<Reader>();
			for (String ruleFilePath : drlFilePath) {
				readers.add(new FileReader(new File(ruleFilePath)));
			}

			// 从Drl规则文件中读取规则
			PackageBuilder backageBuilder = new PackageBuilder();
			for (Reader r : readers) {
				backageBuilder.addPackageFromDrl(r);
			}

			// 检查脚本是否有问题
			if (backageBuilder.hasErrors()) {
				throw new Exception(backageBuilder.getErrors().toString());
			}

			ruleBase.addPackages(backageBuilder.getPackages());
		} catch (DroolsParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 */
	public void refreshEnginRule() {
		ruleBase = RuleBaseFacatory.getRuleBase();
		org.drools.rule.Package[] packages = ruleBase.getPackages();
		for (org.drools.rule.Package pg : packages) {
			ruleBase.removePackage(pg.getName());
		}

		initEngine();
	}

	/*
	 * (non-Javadoc)
	 *
	 */
	public void executeRuleEngine(final PointDomain pointDomain) {
		if (null == ruleBase.getPackages() || 0 == ruleBase.getPackages().length) {
			return;
		}

		StatefulSession statefulSession = ruleBase.newStatefulSession();
		statefulSession.insert(pointDomain);

		// fire
		statefulSession.fireAllRules(new org.drools.spi.AgendaFilter() {
			public boolean accept(Activation activation) {
				return !activation.getRule().getName().contains("_test");
			}
		});

		statefulSession.dispose();
	}
}

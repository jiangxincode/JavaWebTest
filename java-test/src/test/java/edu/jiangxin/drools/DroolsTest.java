package edu.jiangxin.drools;

import org.junit.Assert;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/*
我们假定如下情景：网站伴随业务产生而进行的积分发放操作。比如支付宝信用卡还款奖励积分等。
我们定义一下发放规则：
积分的发放参考因素有：交易笔数、交易金额数目、信用卡还款次数、生日特别优惠等。
定义规则：
	过生日，则加10分，并且将当月交易比数翻倍后再计算积分
	2011-01-08 - 2011-08-08每月信用卡还款3次以上，每满3笔赠送30分
	当月购物总金额100以上，每100元赠送10分
	当月购物次数5次以上，每五次赠送50分
	特别的，如果全部满足了要求，则额外奖励100分
	发生退货，扣减10分
	退货金额大于100，扣减100分
*/
public class DroolsTest {

	@Test
	public void testDrools() {
		// load up the knowledge base
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("ksession-rules");

		PointDomain pointDomain = new PointDomain();
		pointDomain.setUserName("ko");
		pointDomain.setBillThisMonth(3);
		pointDomain.setBackMondy(100d);
		pointDomain.setBuyMoney(500d);
		pointDomain.setBackNums(1);
		pointDomain.setBuyNums(5);
		pointDomain.setBirthDay(true);
		pointDomain.setPoint(0l);

		// go !
		kSession.insert(pointDomain);
		kSession.fireAllRules();
		Assert.assertEquals(380, pointDomain.getPoint());
	}
}
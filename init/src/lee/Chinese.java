package lee;

import org.springframework.beans.factory.InitializingBean;

public class Chinese implements Person, InitializingBean {
	private Axe axe;

	public Chinese() {
		System.out.println("Springʵ��������bean��Chineseʵ��...");
	}

	public void setAxe(Axe axe) {
		System.out.println("Springִ��������ϵע��...");
		this.axe = axe;
	}

	public void useAxe() {
		System.out.println(axe.chop());
	}

	public void init() {
		System.out.println("����ִ�г�ʼ������    init...");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("����ִ�г�ʼ������    afterPropertiesSet...");

	}

}
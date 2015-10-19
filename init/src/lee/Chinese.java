package lee;

import org.springframework.beans.factory.InitializingBean;

public class Chinese implements Person, InitializingBean {
	private Axe axe;

	public Chinese() {
		System.out.println("Spring实例化主调bean：Chinese实例...");
	}

	public void setAxe(Axe axe) {
		System.out.println("Spring执行依赖关系注入...");
		this.axe = axe;
	}

	public void useAxe() {
		System.out.println(axe.chop());
	}

	public void init() {
		System.out.println("正在执行初始化方法    init...");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("正在执行初始化方法    afterPropertiesSet...");

	}

}
package destroy;

import org.springframework.beans.factory.DisposableBean;

public class Chinese implements Person, DisposableBean {
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

	public void close() {
		System.out.println("正在执行初始化方法   close...");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("正在执行初始化方法    destroy...");
		
	}


}
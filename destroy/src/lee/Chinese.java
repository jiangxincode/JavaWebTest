package lee;

import org.springframework.beans.factory.DisposableBean;

public class Chinese implements Person, DisposableBean {
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

	public void close() {
		System.out.println("����ִ�г�ʼ������   close...");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("����ִ�г�ʼ������    destroy...");
		
	}


}
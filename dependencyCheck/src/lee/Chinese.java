package lee;

public class Chinese implements Person {
	private Axe axe;

	private int age;

	public Chinese() {
		System.out.println("Springʵ��������bean��Chineseʵ��...");
	}

	public void setAxe(Axe axe) {
		System.out.println("Springִ��������ϵע��...");
		this.axe = axe;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void useAxe() {
		System.out.println(axe.chop() + " ���˵�����Ϊ��" + age);
	}
}
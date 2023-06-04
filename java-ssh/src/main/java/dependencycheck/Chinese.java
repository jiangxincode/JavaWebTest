package dependencycheck;

public class Chinese implements Person {
	private Axe axe;

	private int age;

	public Chinese() {
		System.out.println("Spring实例化主调bean：Chinese实例...");
	}

	public void setAxe(Axe axe) {
		System.out.println("Spring执行依赖关系注入...");
		this.axe = axe;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void useAxe() {
		System.out.println(axe.chop() + " 此人的年龄为：" + age);
	}
}
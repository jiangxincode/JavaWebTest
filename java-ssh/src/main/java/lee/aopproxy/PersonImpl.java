package lee.aopproxy;

public class PersonImpl implements Person {
	
	private String name;
	private int age;
	
	

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void info() {
		System.out.println("我的名字是： " + name + " , 今年年龄为： " + age);

	}

	@Override
	public void run() {
		if (age > 45) {
			System.out.println("我还年轻，奔跑迅速...");
		} else {
			System.out.println("我年老体弱，只能慢跑...");
		}

	}

}

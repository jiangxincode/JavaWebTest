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
		System.out.println("�ҵ������ǣ� " + name + " , ��������Ϊ�� " + age);

	}

	@Override
	public void run() {
		if (age > 45) {
			System.out.println("�һ����ᣬ����Ѹ��...");
		} else {
			System.out.println("������������ֻ������...");
		}

	}

}

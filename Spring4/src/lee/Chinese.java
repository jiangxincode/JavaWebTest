package lee;

public class Chinese implements Person{
	private Dog dog;

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public Dog getDog() {
		return dog;
	}

	public void test() {
		System.out.println("����һ���й��ˣ��ҵĹ�˵ " + getDog().run());
	}

}

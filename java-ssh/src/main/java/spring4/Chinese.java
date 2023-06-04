package spring4;

public class Chinese implements Person{
	private Dog dog;

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public Dog getDog() {
		return dog;
	}

	public void test() {
		System.out.println("我是一个中国人，我的狗说 " + getDog().run());
	}

}

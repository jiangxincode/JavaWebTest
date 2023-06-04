package simplefactory;

public class American implements Person {
	public String sayHello(String name) {
		return name + ",Hello";
	}

	public String sayGoodBye(String name) {
		return name + ",Good Bye";
	}
}
package spring1;

public class Chinese implements Person {
	public String sayHello(String name) {
		return name + "，您好";
	}

	public String sayGoodBye(String name) {
		return name + "，下次再见";
	}
}

package simplefactory;

public class Client {

	public static void main(String[] args) {
		
		PersonFactory pf = new PersonFactory();
		Person p = null;

		p = pf.getPerson("chinese");
		System.out.println(p.sayHello("张三"));
		System.out.println(p.sayGoodBye("张三"));

		p = pf.getPerson("american");
		System.out.println(p.sayHello("Tom"));
		System.out.println(p.sayGoodBye("Tom"));
		
		
/*
		Person chinese = new Chinese();

		System.out.println(chinese.sayHello("张三"));
		System.out.println(chinese.sayGoodBye("张三"));

		Person american = new American();

		System.out.println(american.sayHello("Tom"));
		System.out.println(american.sayGoodBye("Tom"));
*/
	}
}

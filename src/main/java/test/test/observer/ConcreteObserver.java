package test.test.observer;

public class ConcreteObserver extends Observer {
	@Override
	public void update(Object object) {
		System.out.println("�۲��߸����Լ�");
		System.out.println(object);
	}
}

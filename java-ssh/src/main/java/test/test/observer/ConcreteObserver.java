package test.test.observer;

public class ConcreteObserver extends Observer {
	@Override
	public void update(Object object) {
		System.out.println("观察者更新自己");
		System.out.println(object);
	}
}

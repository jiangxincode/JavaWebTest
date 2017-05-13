package test.test.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {
	List<Observer> list = new ArrayList<Observer>();

	public void attach(Observer observer) {
		this.list.add(observer);
	}

	public void detach(Observer observer) {
		this.list.remove(observer);
	}

	public void notifyObservers() {
		for (Observer observer : list) {
			observer.update("通知观察者");
		}
	}

	public void a() {
		this.notifyObservers();
	}

}

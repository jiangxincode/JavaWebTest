package hibernate3;

import java.util.Set;

public class Customer {
	private Long id;

	private String name;

	@SuppressWarnings("rawtypes")
	private Set orders; // 一对多，通过该变量可以引用到对应的Order集合对象

	@SuppressWarnings("rawtypes")
	public Customer(String name, Set orders) {
		this.name = name;
		this.orders = orders;
	}

	public Customer() {

	}

	@SuppressWarnings("rawtypes")
	public Customer(Set orders) {
		this.orders = orders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@SuppressWarnings("rawtypes")
	public Set getOrders() {
		return orders;
	}

	@SuppressWarnings("rawtypes")
	public void setOrders(Set orders) {
		this.orders = orders;
	}

}

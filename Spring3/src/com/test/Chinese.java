package com.test;

public class Chinese implements Person {
	private Axe axe;

	public Chinese() {
	}

	public void setAxe(Axe axe) {
		this.axe = axe;
	}

	public void useAxe() {
		System.out.println(axe.chop());
	}
}
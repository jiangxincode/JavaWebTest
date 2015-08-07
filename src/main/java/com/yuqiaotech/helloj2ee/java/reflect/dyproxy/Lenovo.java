package com.yuqiaotech.helloj2ee.java.reflect.dyproxy;

public class Lenovo implements ComputerProvider {

	public void sellComputer() {
		System.out.println("卖出去一台电脑");
	}

	public void buyCPU(String brand, int amount) {
		System.out.println("买了" + amount + "片" + brand + "的CPU。");

	}

}

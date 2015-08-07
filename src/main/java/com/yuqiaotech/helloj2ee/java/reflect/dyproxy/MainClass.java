package com.yuqiaotech.helloj2ee.java.reflect.dyproxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理，这个东东如何讲解呢？
 */
public class MainClass {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

	public static void test1() {
		System.out.println("=========test1=============");
		ComputerProvider lenovo = new Lenovo();
		lenovo.sellComputer();
		lenovo.buyCPU("AMD", 200);
		lenovo.sellComputer();
		lenovo.buyCPU("Intel", 100);

		// 现在buyCPU和sellComputer方法执行的时候仅仅是打印一条语句，如果这时希望记录一下买和卖的数量，怎么办呢
		// 最直接的方法是修改buyCPU和sellComputer两个方法的实现。
		// 还有一种方法是不修改原来的类，而是添加一个代理类，如test2()里的方式
		// 再有一种方法是使用动态代理，动态代理不需要写具体的代理类了，而是Proxy.newProxyInstance动态生成一个实现
		// 了ComputerProvider接口的实现类的实例。
		// 当我们的程序调用这个动态生成的对象的方法时，动态实例会去调用创建该实例时传入的InvocationHandler接口的实例的invoke方法
		// 并且把当前动态实例，正在调用的方法，以及传入的参数都传给invoke方法，我们的代码就可以通过判断当前在调用什么方法，动态的做相应处理。
	}

	public static void test2() {
		System.out.println("=========test2=============");
		class ComputerProviderProxy implements ComputerProvider {
			public ComputerProviderProxy(ComputerProvider target) {
				this.target = target;
			}

			public int sellCount = 0;
			public int buyCPUCount = 0;
			public ComputerProvider target;

			public void buyCPU(String brand, int amount) {
				target.buyCPU(brand, amount);
				buyCPUCount += amount;
			}

			public void sellComputer() {
				target.sellComputer();
				sellCount++;
			}
		}
		ComputerProvider target = new Lenovo();
		ComputerProvider lenovo = new ComputerProviderProxy(target);
		lenovo.sellComputer();
		lenovo.buyCPU("AMD", 200);
		lenovo.sellComputer();
		lenovo.buyCPU("Intel", 100);
		System.out.println("*******************");
		// 希望能计算一下总共卖了多少台电脑，总共买了多少CPU。
		System.out.println("共卖了" + ((ComputerProviderProxy) lenovo).sellCount
				+ "台电脑");
		System.out.println("共买了" + ((ComputerProviderProxy) lenovo).buyCPUCount
				+ "片CPU");
	}

	public static void test3() {
		System.out.println("=========test3=============");
		ComputerProvider target = new Lenovo();
		Counter cnt = new Counter(target);
		ComputerProvider lenovo = (ComputerProvider) Proxy.newProxyInstance(
				Lenovo.class.getClassLoader(),
				new Class<?>[] { ComputerProvider.class }, cnt);

		lenovo.sellComputer();
		lenovo.buyCPU("AMD", 200);
		lenovo.sellComputer();
		lenovo.buyCPU("Intel", 100);
		System.out.println("*******************");
		// 希望能计算一下总共卖了多少台电脑，总共买了多少CPU。
		System.out.println("共卖了" + cnt.getSellCount() + "台电脑");
		System.out.println("共买了" + cnt.getBuyCPUCount() + "片CPU");
	}

}

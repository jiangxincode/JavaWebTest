/**
 * 成员内部类 member
 * @author jiangxin
 */
package edu.jiangxin.innerclass;

public class OuterMember {
	private static int i = 1;
	private int j = 10;
	private int k = 20;

	public static void outer_f1() {
		// do more something
	}

	public void outer_f2() {
		// do more something
	}

	// 成员内部类
	class Inner {
		// static int inner_i =100; //内部类中不允许定义静态变量
		int j = 100;// 内部类和外部类的实例变量可以共存
		int inner_i = 1;

		void inner_f1() {
			System.out.println(i); // 外部类的变量如果和内部类的变量没有同名的，则可以直接用变量名访问外部类的变量
			System.out.println(j); // 在内部类中访问内部类自己的变量直接用变量名
			System.out.println(this.j); // 也可以在内部类中用"this.变量名"来访问内部类变量
			System.out.println(OuterMember.this.j); // 访问外部类中与内部类同名的实例变量可用"外部类名.this.变量名"。
			System.out.println(k); // 外部类的变量如果和内部类的变量没有同名的，则可以直接用变量名访问外部类的变量
			outer_f1();
			outer_f2();
		}
	}

	// 外部类的非静态方法访问成员内部类
	public void outer_f3() {
		Inner inner = new Inner();
		inner.inner_f1();
	}

	// 外部类的静态方法访问成员内部类，与在外部类外部访问成员内部类一样
	public static void outer_f4() {
		OuterMember out = new OuterMember(); // 建立外部类对象
		Inner inner = out.new Inner(); // 根据外部类对象建立内部类对象
		inner.inner_f1(); // 访问内部类的方法
	}

	public static void main(String[] args) {
		outer_f4();
	}
}

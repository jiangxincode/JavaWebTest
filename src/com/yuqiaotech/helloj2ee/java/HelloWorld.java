package com.yuqiaotech.helloj2ee.java;

//面向对象
//这样就定义了一个类，类名叫HelloWorld，
//这个类有一个私有属性叫name
//有个公有方法叫greeting，
//如果了解C的话，可以进一步了解一下结构体，函数指针，
//http://feizf.blogbus.com/logs/3990457.html

//变量(基本类型 引用类型) 值  类 基本数据类型 new操作符 实例化 对象 实例 类型（变量类型，值的类型） ， 赋值 方法调用
//传值
class HelloWorld{
	protected String name;
	public void greeting(){
		System.out.println("hello "+name);
	}
	//当本方法被调用的时候，会为本方法分配一个堆栈，在该堆栈里创建一个变量hello，
	//然后把实参的值拷贝到hello这个变量的空间里。
	public static void foo(HelloWorld hello){
		hello = new HelloWorld();
		hello.greeting();
	}
	static class HelloWorldChina extends HelloWorld{
		public void greeting(){
			System.out.println("你好 "+name);
		}
		public void greeting(String x){
			System.out.println("你好 "+name);
		}
	}
	public static void main(String[] args){
		int i = 10;//变量i的类型为int，是基本数据类型，这句话定义了变量i，给该变量分配了内存，内存的内容是10的二进制内容。
		//new操作符生成一个HelloWorld的对象（实例），堆中为他分配了相应的空间，并调用该类的构造函数，然后并返回首地址。
		//=，为赋值，把new操作符返回的地址放入h这个变量的内存空间里。
		//h是个变量他的类型是HelloWorld，h的值实际是一个地址，而不是这个对象。
		//称为把new出来的对象的引用赋值给h这个变量
		//通过这个变量就可以访问这个对象的属性和方法
		HelloWorld h = new HelloWorld();
		h.name = new String("abc");
		h.name=args[0];

		//又生成一个HelloWorld的对象，并赋值给h2这个变量。
		HelloWorld h2 = new HelloWorld();
		h2.name=args[1];

		//下面两个方法输出的内容不同
		h.greeting();
		h2.greeting();
		HelloWorld.foo(h);
		//hx这个变量的类型是HelloWorld，但他指向的对象的类似是HelloWorldChina。
		//变量所指向的对象的类型只能是变量的类型的子类。
		//变量所指向的对象只能是变量的类型的子类的实例。
		HelloWorld hx = new HelloWorldChina();
		HelloWorld.foo(hx);
		
		HelloWorldChina hc = (HelloWorldChina)hx;
		hc.greeting("八戒");
	}
//P.S. 使用new操作符，生成某个类的对象，简单的讲就是根据类的定义申请一块合适大小的空间
//然后调用该类的特定构造函数，然后返回地址。
}

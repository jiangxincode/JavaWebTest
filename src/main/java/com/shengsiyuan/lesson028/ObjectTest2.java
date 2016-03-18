package com.shengsiyuan.lesson028;

public class ObjectTest2 {
	public static void main(String[] args) {
		{
			Object object1 = new Object();
			Object object2 = new Object();
			System.out.println(object1 == object2);
			System.out.println("----------------");
		}

		{
			Object object1 = new Object();
			Object object2 = new Object();
			System.out.println(object1.equals(object2));
			System.out.println("----------------");
		}

		{
			String string1 = new String("abc");
			String string2 = new String("abc");
			System.out.println(string1 == string2);
			System.out.println("----------------");
		}

		{
			String string1 = "abc";
			String string2 = "abc";
			System.out.println(string1 == string2);
			System.out.println("----------------");
		}

		{
			String string1 = new String("abc");
			String string2 = "abc";
			System.out.println(string1 == string2);
			System.out.println("----------------");
		}

		{
			String string1 = "hello";
			String string2 = "hel";
			String string3 = "lo";
			System.out.println(string1 == string2 + string3);
			System.out.println("----------------");
		}

		{
			String string1 = "hello";
			System.out.println(string1 == "hel" + "lo");
			System.out.println("----------------");
		}
	}
}

package com.yuqiaotech.helloj2ee.java.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * annotation的使用实例。 请观察User类的getUsername，然后对比本代码打印的内容。
 */
public class AnnotationTest {

	public static void main(String[] args) throws SecurityException,
			NoSuchMethodException {
		
		// 获取getUsername方法，然后列出其所有annotation的类型。
		Method m = User.class.getMethod("getUsername");
		Annotation[] annotations = m.getAnnotations();
		System.out.println("1、getUsername方法有下属类型的注解:");
		for (Annotation annotation : annotations) {
			System.out.println(annotation.annotationType());
		}
		// 获取getUsername方法类型为Comment的annotation的value属性的值。
		Comment commentAnnotation = m.getAnnotation(Comment.class);
		System.out.println("2、Comment注解的value属性的值为:commentAnnotation.value()="
				+ commentAnnotation.value());

		System.out.println("3、类定义上的annotation列表");
		Annotation[] classAnnotations = User.class.getAnnotations();
		for (int i = 0; i < classAnnotations.length; i++) {
			Annotation a = classAnnotations[i];
			System.out.println(a.annotationType().getName());
		}
	}
}

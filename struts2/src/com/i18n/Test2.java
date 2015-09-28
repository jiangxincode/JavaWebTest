package com.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class Test2 {
	public static void main(String[] args) {
		Locale locale = Locale.CHINESE;

		ResourceBundle bundle = ResourceBundle.getBundle("hellofile", locale);

		String value = bundle.getString("hello");

		System.out.println(value);
	}
}

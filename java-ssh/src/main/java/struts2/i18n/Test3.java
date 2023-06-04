package struts2.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Test3 {
	public static void main(String[] args) {
		Locale locale = Locale.US;

		ResourceBundle bundle = ResourceBundle.getBundle("hellofile", locale);

		String value = bundle.getString("hello");

		String message = MessageFormat.format(value, new Object[] { "ол╣Щ" });

		System.out.println(message);
	}
}

package edu.jiangxin.path;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
		// 创建绝对URL对象：
		URL gamelan = new URL("http://www.gamelan.com/");

		// 创建相对URL对象

		gamelan = new URL("http://www.gamelan.com/pages/");

		URL gamelanGames = new URL(gamelan, "Gamelan.game.html");

		URL gamelanNetwork = new URL(gamelan, "Gamelan.net.html");

		// 因为，URL类有如下的构造函数：
		// public URL(String str);
		// public URL(URLcontext, Stringstr)

		// 另外：使用这种相对URL还可以创建到网页内部某个标记的URL对象：

		URL gamelanNetworkBottom = new URL(gamelanNetwork, "#BOTTOM");

		// 其他的几种URL构造函数：
		new URL("http", "www.gamelan.com", "/pages/Gamelan.net.html");
		new URL("http://www.gamelan.com/pages/Gamelan.net.html");
		gamelan = new URL("http", "www.gamelan.com", 80, "pages/Gamelan.network.html");
		// （指向：http://www.gamelan.com:80/pages/Gamelan.network.html）

		// 有些URL含有特殊字符，比如空格：http://foo.com/hello world/
		// 这时的URL就必须进行编码：将空格用%20替代：
		URL url = new URL("http://foo.com/hello%20world");
		// 以上URL中只有一个特殊字符，因此手动编码相对简单。当URL中的特殊字符很多时，或者特殊字符数目不确定时，就不能使用手动编码了，这时需要使用java.net.URI类去自动完成编码：
		URI uri = new URI("http", "foo.com", "/hello world/", "");
		// 然后，将URI转换成URL：
		url = uri.toURL();

	}

}

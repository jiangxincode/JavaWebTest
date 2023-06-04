package proxy.proxy;

//¿Í»§¶Ëµ÷ÓÃ

public class Client {
	public static void main(String[] args) {
		Subject sub = new ProxySubject();

		sub.request();
	}
}

package proxy.proxy;

//代理角色

public class ProxySubject extends Subject {
	private RealSubject realSubject; // 以真实角色作为代理角色的属性

	public ProxySubject() {
	}

	public void request() // 该方法封装了真实对象的request方法
	{
		preRequest();

		if (realSubject == null) {
			realSubject = new RealSubject();
		}

		realSubject.request(); // 此处执行真实对象的request方法

		postRequest();
	}

	private void preRequest() {
		System.out.println("pre request");
	}

	private void postRequest() {
		System.out.println("post request");
	}

}

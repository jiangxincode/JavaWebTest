package delegator;

import java.lang.reflect.Method;
import java.util.List;

public class Delegator4List extends Delegator {

	@SuppressWarnings("rawtypes")
	private List orginClass = null; // 原始对象
	@SuppressWarnings("rawtypes")
	private List proxyClass = null; // 代理对象
	
	@SuppressWarnings("rawtypes")
	public Delegator4List(List orgin) {
		super(orgin);
		orginClass = orgin;
		proxyClass = (List) super.obj_proxy;
	}

	@SuppressWarnings("rawtypes")
	public List getOrgin() {
		return orginClass;
	}

	@SuppressWarnings("rawtypes")
	public List getProxy() {
		return proxyClass;
	}
	
	public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
		if (method.getName().equals("toString")) { // 修改size处理逻辑
			Object res2 = new String("list");
			System.out.println("调用委托的方法");
			return res2;
		} else {
			System.out.println("调用原始的方法");
			return super.invoke(obj, method, args);
		}
	}
}

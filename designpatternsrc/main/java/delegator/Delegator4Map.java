package delegator;

import java.lang.reflect.Method;
import java.util.Map;

public class Delegator4Map extends Delegator {

	@SuppressWarnings("rawtypes")
	private Map orginClass = null; // 原始对象
	@SuppressWarnings("rawtypes")
	private Map proxyClass = null; // 代理对象
	
	@SuppressWarnings("rawtypes")
	public Delegator4Map(Map orgin) {
		super(orgin);
		orginClass = orgin;
		proxyClass = (Map) super.obj_proxy;
	}

	@SuppressWarnings("rawtypes")
	public Map getOrgin() {
		return orginClass;
	}

	@SuppressWarnings("rawtypes")
	public Map getProxy() {
		return proxyClass;
	}

	public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
		if (method.getName().equals("size")) { // 修改size处理逻辑
			Object res2 = new Integer(-1);
			System.out.println("调用委托的方法");
			return res2;
		} else {
			System.out.println("调用原始的方法");
			return super.invoke(obj, method, args);
		}
	}
}
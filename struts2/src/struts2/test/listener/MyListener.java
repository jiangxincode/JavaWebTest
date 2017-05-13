package struts2.test.listener;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class MyListener implements PreResultListener {

	public void beforeResult(ActionInvocation invocation, String resultCode) {
		System.out.println("hello world");
	}

}

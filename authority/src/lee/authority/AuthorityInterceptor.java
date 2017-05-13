package lee.authority;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AuthorityInterceptor implements MethodInterceptor {

	private String user;
	
	
	public void setUser(String user) {
		this.user = user;
	}


	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("===============");
		String methodName = invocation.getMethod().getName();
		
		if(!user.equals("admin") && !user.equals("registedUser")) {
			System.out.println("您无权执行该方法");
			return null;
		} else if(user.equals("registedUser") && methodName.equals("modify")) {
			System.out.println("您不是管理员，无法修改数据");
			return null;
		} else {
			return invocation.proceed();
		}
		
	}

}

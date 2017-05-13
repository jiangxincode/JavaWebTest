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
			System.out.println("����Ȩִ�и÷���");
			return null;
		} else if(user.equals("registedUser") && methodName.equals("modify")) {
			System.out.println("�����ǹ���Ա���޷��޸�����");
			return null;
		} else {
			return invocation.proceed();
		}
		
	}

}

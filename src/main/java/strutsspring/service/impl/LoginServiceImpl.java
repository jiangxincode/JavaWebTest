package strutsspring.service.impl;

import strutsspring.service.LoginService;

/**
 * �������������ҵ����
 * 
 * @author zhanglong
 *
 */

public class LoginServiceImpl implements LoginService {
	public boolean isLogin(String username, String password) {
		if ("hello".equals(username) && "world".equals(password)) {
			return true;
		}

		return false;
	}
}

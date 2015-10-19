package com.test.service.impl;

import com.test.service.LoginService;

/**
 * 该类完成真正的业务处理
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

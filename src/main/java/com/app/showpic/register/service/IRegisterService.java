package com.app.showpic.register.service;

import java.util.Map;

public interface IRegisterService {
	/**
	 * 注册用户
	 * @param params
	 */
	int registerUser(Map<String, String> params);

}

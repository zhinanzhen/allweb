package com.app.showpic.login.sercive.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.showpic.login.dao.LoginMapper;
import com.app.showpic.login.sercive.ILoginSercive;
import com.app.showpic.register.bean.User;
@Service
public class LoginSercive implements ILoginSercive {
	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public User ajaxLogin(Map<String, String> params) {
		return loginMapper.ajaxLogin(params);
	}

}

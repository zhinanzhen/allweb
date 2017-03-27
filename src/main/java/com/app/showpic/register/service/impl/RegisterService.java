package com.app.showpic.register.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.showpic.register.dao.RegisterMapper;
import com.app.showpic.register.service.IRegisterService;

@Service
public class RegisterService implements IRegisterService {
	@Autowired
	RegisterMapper registerMapper;
	
	@Override
	public int registerUser(Map<String, String> params) {
		return registerMapper.registerUser(params);
	}

}

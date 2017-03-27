package com.app.showpic.login.dao;

import java.util.Map;

import com.app.showpic.register.bean.User;

public interface LoginMapper {

	User ajaxLogin(Map<String, String> params);

}

package com.app.showpic.login.sercive;

import java.util.Map;

import com.app.showpic.register.bean.User;

public interface ILoginSercive {

	User ajaxLogin(Map<String, String> params);

}

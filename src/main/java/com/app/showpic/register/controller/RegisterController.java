package com.app.showpic.register.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.common.BaseController;
import com.app.common.utils.AjaxTool;
import com.app.showpic.register.service.IRegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController {
	@Autowired
	IRegisterService registerService;
	
	@RequestMapping("/registerPage.html")
	public ModelAndView registerPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("showpic/register/register");
	}
	@RequestMapping("/registerUser.html")
	public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response) {
		String[] paramNames = {"userCode", "userPwd","phone","email","sex"};
    	Map<String,String> params = getParamMap(request, paramNames);
    	registerService.registerUser(params);
		return AjaxTool.returnAjaxResponse(response, "/login/loginPage.html") ;
	}
}

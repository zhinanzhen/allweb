package com.app.showpic.login.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.common.BaseController;
import com.app.common.Constants;
import com.app.common.utils.AjaxTool;
import com.app.showpic.login.sercive.ILoginSercive;
import com.app.showpic.register.bean.User;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	private Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	ILoginSercive loginSercive;

	@RequestMapping("/loginPage.html")
	public ModelAndView loginPage(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("showpic/login/login");
	}

	@RequestMapping("/ajaxLogin.html")
	public ModelAndView ajaxLogin(HttpServletRequest request,
			HttpServletResponse response) {
		String[] paramNames = { "userCode", "userPwd" };
		Map<String, String> params = getParamMap(request, paramNames);
		User user = loginSercive.ajaxLogin(params);
		if (user != null) {
//			String url = StringUtil.null2blank(((String) request.getAttribute("requestUri")).replace("~`", "&"));
			String url = "";
			request.getSession().setAttribute(Constants.LOGIN_USER, user);
			if("".equals(url)){
				return AjaxTool.returnAjaxResponse(response,"{success:true,url:'/home/homePage.html'}");
			}else{
				return AjaxTool.returnAjaxResponse(response,"{success:true,url:'"+url+"'}");
			}
		} else {
			return AjaxTool.returnAjaxResponse(response, "{success:false}");
		}
	}
}

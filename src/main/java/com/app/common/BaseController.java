package com.app.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.app.common.utils.StringUtil;
import com.app.common.utils.ValidateUtils;

public class BaseController {
	/**
	 * 将参数组合成Map
	 * @param request
	 * @param paramNames
	 * @return
	 */
	public Map<String,String> getParamMap(HttpServletRequest request,String... paramNames){
		Map<String,String> params = new HashMap<String,String>();
		if(ValidateUtils.isEmpty(paramNames)){
			return params;
		}
		for(String paramName :paramNames){
			String paramValue = getParam(request, paramName);
			if(ValidateUtils.isNotEmpty(paramValue)){
				params.put(paramName, paramValue);
			}
		}
		return params;
	}
	/**
	 * 获取页面参数
	 * @param request
	 * @param paramName
	 * @return
	 */
	public String getParam(HttpServletRequest request,String paramName){
		return StringUtil.null2blank(request.getParameter(paramName)).trim();
	}
	
	/**
	 * 跳转到页面
	 * @param path
	 * @return
	 */
	public ModelAndView returnJsp(String path){
		return new ModelAndView(path);
	}
}

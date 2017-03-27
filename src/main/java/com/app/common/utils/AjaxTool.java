package com.app.common.utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.app.common.enums.RespStatusEnum;

public class AjaxTool {

	public static String splitCharLevel1 = "Level@@@@@";
	public static String splitCharLevel2 = "Level@@@@";
	//JSONObject json = new JSONObject();
	public static ModelAndView returnAjaxResponse(HttpServletResponse response,
			String msg) {

		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write(msg);
			return null;
		} catch (IOException e1) {
			e1.printStackTrace();
			throw new RuntimeException(e1);
		}

	}

	public static ModelAndView returnAjaxResponse(HttpServletResponse response,
			String userMsg, Exception e) {
		String msg = "";
		StackTraceElement[] trace = e.getStackTrace();
		for (int i = 0; i < trace.length; i++) {
			StackTraceElement ste = trace[i];
			msg += ste.toString() + "\n";
		}
		return returnAjaxResponse(
				response,
				"1-" + userMsg + "\n" + e.getMessage() + "\n"
						+ e.getLocalizedMessage() + "\n" + msg);
	}

	public static ModelAndView returnAjaxResponse(HttpServletResponse response,
			Exception e) {
		return returnAjaxResponse(response, "", e);
	}

	@SuppressWarnings("rawtypes")
	public static String getTaskAjaxString(Object obj) {
		// TODO Auto-generated method stub
		if (obj == null)
			return null;

		String taskString = "";

		Class c = obj.getClass();
		Method m[] = c.getDeclaredMethods();
		for (Method method : m) {
			try {

				taskString += addAttribute(method, obj);

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		return taskString;

	}

	/**
	 * 增加属�?��??
	 * 
	 * @param methodName
	 * @param attributeValue
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private static String addAttribute(Method method, Object ai) {
		String methodName = method.getName();
		if (methodName.startsWith("get")) {
			Object o = null;
			try {
				o = method.invoke(ai);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Class methodReturnType = method.getReturnType();
			String className = methodReturnType.getName();
			if (o != null) {
				String value = o.toString();

				return addAttributeValue(methodName, className, value);
			} else
				return "";
		} else
			return "";
	}

	private static String addAttributeValue(String methodName,
			String className, String value) {
		String returnValue = value;
		if (className.equalsIgnoreCase("java.sql.Timestamp"))
			returnValue = returnValue.substring(0, 10).replaceAll("-", "");
		return "[" + methodName.replace("get", "") + ":" + returnValue + "]";
	}

	/**
	 * 返回ajax响应
	 * 
	 * @param response
	 * @param msg
	 * @author jun.liu
	 */
	public static ModelAndView returnAjaxResponse(HttpServletResponse response,
			String msg, RespStatusEnum respStatusEnum) {
		switch (respStatusEnum) {
		case HTML:
			response.setContentType("text/html;charset=UTF-8");
			break;
		case JSON:
			// response.setContentType("application/json;charset=UTF-8");
			response.setHeader("Content-Type", "application/json");
			break;
		case XML:
			response.setContentType("text/xml;charset=UTF-8");
			break;
		case 纯文本:
			response.setContentType("text/plan;charset=UTF-8");
			break;
		}
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(msg);
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}

package com.app.common.signon;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.common.Constants;

@SuppressWarnings("serial")
public class UserFilter extends HttpServlet implements Filter {
	
	private FilterConfig config;
	private static String signOnErrorPage = "login/loginPage.html";
	
	public void destroy() {
	}
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;// 获取request对象
		String currentURL = request.getRequestURI();//获取用户访问的URL
		currentURL = currentURL.replaceAll("//", "/");// 手机客户端URL 双斜杠转单斜杠
		String path = request.getContextPath();
		if (releaseMethods(request.getServletPath())) {// 判断拦截的返回值（如果是true则进行拦截处理）
			boolean signedOn = false;
			if (request.getSession().getAttribute(Constants.LOGIN_USER) != null) {// 判断Session对象中的用户名是不是为空，如果不为空则不进行拦截
				signedOn = true;
			}
			if(signedOn){
				chain.doFilter(req, res);
			}else {// 如果Session中的用户为空，则进行拦截
				//登录页面
				String logonStrings = config.getInitParameter("logonStrings");        // 登录登陆页面
				String[] logonList = logonStrings.split(";");
				String requestUri = request.getServletPath() +"?" + request.getQueryString();
				requestUri = requestUri.replace("&", "~`");
				request.setAttribute("requestUri", requestUri);
				System.out.println(request.getAttribute("requestUri"));
				for(String s : logonList){
					if (currentURL.indexOf(s) != -1){
						chain.doFilter(req, res);
						return;
					}
				}
				if (currentURL.equals(path+"/index.jsp") || currentURL.equals(path+"/")) {
					chain.doFilter(req, res);
				}else {
					HttpServletResponse hrep = (HttpServletResponse) res;
					hrep.sendRedirect(path + "/"+signOnErrorPage);
				}
			}
		} else {// 判断拦截的返回值（如果是false则不进行拦截）
			chain.doFilter(req, res);
		}
	}

	// 判断要拦截的文件的类型，其除了登录Action和图片文件夹和JS类库以外，其他全部拦截
	public boolean releaseMethods(String txt) {
		boolean isok = true;
		if (txt.contains("register")  || txt.contains("login") || txt.contains("fileUpload"))
			isok = false;
		return isok;
	}

	public void init(FilterConfig arg0) throws ServletException {
		config = arg0;
	}
}
package com.app.common.sync.servlert;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 这是另一个系统中的servlert,异步通知发送到此
 * @author xxn
 * @date 2015年12月4日  下午4:02:42
 */
public class NotifyResultServlet extends HttpServlet {

	private static final long serialVersionUID = -6141570366402059650L;
//	private ServletConfig config=null;
//    private ServletContext application;
//    private ManagerSyncService managerSyncService;
    
	public NotifyResultServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void init(ServletConfig config) throws ServletException {
		super.init();
//		this.config = config;
//		this.application = config.getServletContext();
//        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
//        this.managerSyncService = (ManagerSyncService) context.getBean("managerSyncService");
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String src = request.getParameter("src");
		String sign = request.getParameter("sign");
		String tradeId = request.getParameter("tradeId");
		String type = request.getParameter("type");
		String notifyUrl = request.getParameter("notifyUrl");
		System.out.println("src==========>"+src);
		System.out.println("sign==========>"+sign);
		System.out.println("tradeId==========>"+tradeId);
		System.out.println("type==========>"+type);
		System.out.println("notifyUrl==========>"+notifyUrl);
/*		NotifyParamVo paramVo = new NotifyParamVo();
		paramVo.setNotifyUrl(notifyUrl);
		paramVo.setSign(sign);
		paramVo.setSrc(src);
		paramVo.setTradeId(tradeId);
		paramVo.setType(type);
*/		String result = "";
		try {
//			IBaseNotifySyncService sync = managerSyncService.getNotifyServiceBean(tradeId);
//			if(sync!=null){
//				result = sync.baseNotify(paramVo);
//			}else{
//				result = "{'result':'0','exception':'没有找到发送通知的Bean'}";
//			}
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
            out.print(result);
            out.flush(); 
            out.close();
		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("application/json");
			result = "{'result':'0','exception':'调用异常'}";
			PrintWriter out = response.getWriter(); 
            out.print(result);
            out.flush();
            out.close();
		}
	}
	
}

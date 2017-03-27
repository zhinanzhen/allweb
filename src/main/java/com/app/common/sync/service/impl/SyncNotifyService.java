package com.app.common.sync.service.impl;

import java.util.concurrent.ExecutorService;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;

import com.app.common.sync.SyncPathConstant;
import com.app.common.sync.bean.SysNotifyContent;
import com.app.common.sync.bean.SysNotifyParams;
import com.app.common.sync.service.ISyncNotifyService;
import com.app.common.utils.DateUtils;
import com.app.common.utils.ThreadPoolUtils;

/**
 * 实现通知
 * @author xxn
 * @date 2015年12月4日  下午4:48:47
 */
public class SyncNotifyService implements ISyncNotifyService {
	
	public static ExecutorService exceutor = ThreadPoolUtils.exceutor;
	
	public void syncBaseResult(final String src, final String sign, final String tradeId, final String type, final String notifyUrl, final String maxSendNum){
        exceutor.execute(new Runnable() {
            @Override
            public void run() {
            	SysNotifyParams resultSync = new SysNotifyParams();
            	resultSync.setFlag("0");//默认失败
            	resultSync.setCreateTime(DateUtils.getNowTime());
            	resultSync.setTradeId(tradeId);
            	resultSync.setType(type);
            	resultSync.setNotifyUrl(notifyUrl);
            	resultSync.setIsRepeat("1");//1-需要 重复发送
            	resultSync.setLastSendTime(DateUtils.getNowTime());
            	if(StringUtils.isNotEmpty(maxSendNum)){
            		resultSync.setMaxSendNum(maxSendNum);
            	}
            	SysNotifyContent content = new SysNotifyContent();
            	content.setSign(sign);
            	content.setSrc(src);
//            	loanDao.save(resultSync);
                content.setNotifyId(resultSync.getId());
//                loanDao.save(content);
                
                /*
                 	HttpClient httpclient = new HttpClient();
					httpclient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"UTF-8");
					httpclient.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
				    PostMethod postMethod = new PostMethod(url);
				    postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
				    postMethod.setRequestBody(data);
				    int statusCode = httpclient.executeMethod(postMethod);
                 */
                
                HttpClient httpclient = new HttpClient();
                httpclient.getParams().setParameter(HttpConnectionParams.CONNECTION_TIMEOUT,  20000);//连接时间20s
                httpclient.getParams().setParameter(HttpConnectionParams.SO_TIMEOUT,  60000);//数据传输时间60s
                httpclient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"UTF-8");
                PostMethod postMethod = new PostMethod(SyncPathConstant.NOTICE_SYNC_RESLUT_URL);
                NameValuePair[] data = { new NameValuePair("src", src), new NameValuePair("sign", sign)
                , new NameValuePair("tradeId", tradeId), new NameValuePair("type", type), 
                new NameValuePair("notifyUrl", notifyUrl)};
                postMethod.setRequestBody(data);
                try{
                    int statusCode = httpclient.executeMethod(postMethod);
                    System.out.println(statusCode);
                    if(HttpStatus.SC_OK==statusCode){
                        byte[] responseBodyByte = postMethod.getResponseBody();
                        String responseBody = new String(responseBodyByte,"UTF-8");
                        System.out.println(responseBody);
                        JSONObject jsonObject = JSONObject.fromObject(responseBody);
                        String flag = jsonObject.get("result").toString();
                        String exception = jsonObject.get("exception").toString();
                        System.out.println("----------通知清算结果成功------" + flag);
                        resultSync.setFlag(flag);
                        resultSync.setException(exception);
//                        loanDao.update(resultSync);
                     }
                    else{
                    	resultSync.setException("代理服务器异常，异常代码："+statusCode);
//                    	loanDao.update(resultSync);
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                    resultSync.setException("代理服务器异常。");
//                    loanDao.update(resultSync);
                }
            }
        });
    }
}

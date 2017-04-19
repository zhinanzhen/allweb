package com.yunpan;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.app.socket.server.SocketServer;

public class CrackYunPan {
	private static List<Header> headers = new ArrayList<Header>();
	
	private static List<Header> getHeaders() {
		headers.add(new Header("Host","pan.baidu.com"));
		headers.add(new Header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0"));
		headers.add(new Header("Accept","image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, application/x-shockwave-flash,"
				+ " application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*"));
		headers.add(new Header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3"));
		headers.add(new Header("Accept-Encoding", "gzip, deflate, br"));
		headers.add(new Header("Referer", "https://pan.baidu.com/share/init?shareid=1243612824&uk=2451764389"));
		headers.add(new Header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"));
		headers.add(new Header("X-Requested-With", "XMLHttpRequest"));
		headers.add(new Header("Content-Length", "27"));
		headers.add(new Header("Cookie", "BAIDUID=2E2308406083DBC22BE962F1589EA732:FG=1; PANWEB=1; Hm_lvt_7a3960b6f067eb0085b7f96ff5e660b0=1490931772; Hm_lpvt_7a3960b6f067eb0085b7f96ff5e660b0=1490931772"));
		headers.add(new Header("Connection", "Keep-Alive"));
		headers.add(new Header("Pragma", "no-cache"));
		headers.add(new Header("Cache-Control", "no-cache"));
		return headers;
	}
	public static void main(String[] args) throws HttpException, IOException {
		NameValuePair[] data = {new NameValuePair("pwd","vf492"),
				new NameValuePair("vcode",""),
				new NameValuePair("vcode_str","")};
		
		HttpClient client = new HttpClient();
//		client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"UTF-8");
		client.getHostConfiguration().getParams().setParameter("http.default-headers", getHeaders());
		//"http://pan.baidu.com/share/verify?shareid=3637868656&uk=2919458905&t=1490927866798&bdstoken=null&channel=chunlei&clienttype=0&web=1&app_id=250528&logid=MTQ5MDkyNzg2NjgwMTAuNTk0MTIzNDU4NjE1ODk4MQ=="
		PostMethod postMethod = new PostMethod("https://pan.baidu.com/share/verify?shareid=1243612824&uk=2451764389&t=1490931778472&bdstoken=null&channel=chunlei&clienttype=0&web=1&app_id=250528&logid=MTQ5MDkzMTc3ODQ3ODAuOTAxMzAwMzM5Nzk2MjA4Mg==");
//		postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		
		postMethod.setRequestBody(data);
		int statusCode = client.executeMethod(postMethod);
		System.out.println(statusCode);
		 if(statusCode == HttpStatus.SC_OK){
		    	byte[] responseBodyByte = postMethod.getResponseBody();
			    String responseBody = new String(responseBodyByte,"UTF-8");
			    System.out.println(responseBody);
		    }else {
		    	System.out.println("异常");
		    }
	}
}

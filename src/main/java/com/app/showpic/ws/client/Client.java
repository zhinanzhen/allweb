package com.app.showpic.ws.client;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.ConnectException;
import java.rmi.RemoteException;
import java.util.Properties;

import org.apache.axis2.AxisFault;
import org.apache.commons.lang3.StringUtils;

import com.app.showpic.ws.client.TestWebServiceStub.Sayhello;
import com.app.showpic.ws.client.TestWebServiceStub.SayhelloResponse;

/**
 * 客户端
 * @author xxn
 * @date 2016年3月11日  上午11:21:32
 */
public class Client {
	private TestWebServiceStub service;

	public Client() {
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("path.properties");
		Properties prop = new Properties();
		String webserviceUrl = "";
		try {
			prop.load(in);
			webserviceUrl = prop.getProperty("webservice");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("初始WebService服务异常");
		}finally{
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException("初始WebService服务异常");
				}
			}
		}
		if(StringUtils.isNotBlank(webserviceUrl)){
			try {
				service = new TestWebServiceStub(webserviceUrl+"/TestWebService?wsdl");
			} catch (AxisFault e) {
				e.printStackTrace();
				throw new RuntimeException("初始化WebService服务异常");
			}
		}
	}

	public Client(String url) {
		try {
			service = new TestWebServiceStub(url);
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}
	public String sayhello(String name) throws ConnectException{
		Sayhello bean = new TestWebServiceStub.Sayhello(); 
		bean.setName(name);
		try {
			SayhelloResponse response = service.sayhello(bean);
			return response.get_return();
		} catch (RemoteException e) {
			e.printStackTrace();
			throw new ConnectException("webservice异常");
		}
	}
	
}

package com.app.showpic.ws.client;

import javax.xml.namespace.QName;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

/**
 * 不生成客户端--直接调用
 * @author xxn
 * @date 2016年3月11日  上午11:28:03
 */
public class WsClient {
	private RPCServiceClient serviceClient;
	private Options options;
	private EndpointReference targetEPR;

	public WsClient(String endpoint) throws AxisFault {
		serviceClient = new RPCServiceClient();
		options = serviceClient.getOptions();
		targetEPR = new EndpointReference(endpoint);
		options.setTo(targetEPR);
	}

	public Object[] invokeOp(String targetNamespace, String opName,
			Object[] opArgs, Class<?>[] opReturnType) throws AxisFault,
			ClassNotFoundException {
		// 设定操作的名称
		QName opQName = new QName(targetNamespace, opName);
		// 设定返回值
		// Class<?>[] opReturn = new Class[] { opReturnType };
		// 操作需要传入的参数已经在参数中给定，这里直接传入方法中调用
		return serviceClient.invokeBlocking(opQName, opArgs, opReturnType);
	}

	public static void main(String[] args) throws AxisFault,
			ClassNotFoundException {
		final String endPointReference = "http://localhost:8080/all_web/services/TestWebService?wsdl";
		final String targetNamespace = "http://ws.apache.org/axis2";
		WsClient client = new WsClient(endPointReference);
		String opName = "sayhello";
		Object[] opArgs = new Object[] { "Repace中心" };
		Class<?>[] opReturnType = new Class[] { String[].class };
		Object[] response = client.invokeOp(targetNamespace, opName, opArgs,
				opReturnType);
		System.out.println(((String[]) response[0])[0]);
	}
}

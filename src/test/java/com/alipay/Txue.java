package com.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayOpenPublicTemplateMessageIndustryModifyRequest;
import com.alipay.api.response.AlipayOpenPublicTemplateMessageIndustryModifyResponse;
import com.alipay.config.AlipayConfig;
import com.alipay.sign.RSA;

public class Txue {
	private static final String APP_ID2 = "2016082000300519";
	
	public static void main(String[] args) throws AlipayApiException {
		//实例化客户端
		AlipayClient client = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do" , APP_ID2 , AlipayConfig.private_key2 , "json" , AlipayConfig.input_charset , AlipayConfig.alipay_public_key2);
		//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.open.public.template.message.industry.modify 
		AlipayOpenPublicTemplateMessageIndustryModifyRequest request = new AlipayOpenPublicTemplateMessageIndustryModifyRequest();
		//SDK已经封装掉了公共参数，这里只需要传入业务参数
		//此次只是参数展示，未进行字符串转义，实际情况下请转义
		String data = "{\"primary_industry_name\":\"IT科技/IT软件与服务\",\"primary_industry_code\":\"10001/20102\",\"secondary_industry_code\":\"10001/20102\", \"secondary_industry_name\":\"IT科技/IT软件与服务\" }";
		String sign = RSA.sign(data, AlipayConfig.private_key2, AlipayConfig.input_charset);
		request.setBizContent(sign);
		AlipayOpenPublicTemplateMessageIndustryModifyResponse response = client.execute(request); 
		//调用成功，则处理业务逻辑
		if(response.isSuccess()){
			System.out.println(response.getBody()+response.getCode()+response.getErrorCode()+""+response.getMsg());
		}
	}
}

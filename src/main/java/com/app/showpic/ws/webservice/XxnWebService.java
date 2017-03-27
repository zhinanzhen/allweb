package com.app.showpic.ws.webservice;

import org.springframework.stereotype.Component;

@Component
public class XxnWebService {
	public String sayhello(String name){
		System.out.println("hello"+name);
		return "hello"+name;
	}
}

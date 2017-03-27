package com.design_pattern.strategy;

import org.springframework.web.context.support.XmlWebApplicationContext;

public class Client {

	public static void main(String[] args) {
		Strategy strategy = new AStrategy();
		strategy.strategyInterface();
		XmlWebApplicationContext sx;
	}

}

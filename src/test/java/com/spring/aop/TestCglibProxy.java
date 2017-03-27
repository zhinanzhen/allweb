package com.spring.aop;

/**
 * 此处没有实现接口
 * @author xxn
 * @date 2016年5月3日  下午2:48:48
 */
public class TestCglibProxy {
	public static void main(String[] args) {
		DefaultOffer dOffer = (DefaultOffer) new CglibProxyFactory().bind(new DefaultOffer());
		dOffer.sendOffer();
	}
}

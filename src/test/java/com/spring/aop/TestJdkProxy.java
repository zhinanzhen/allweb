package com.spring.aop;

/**
 * 实现接口
 * @author xxn
 * @date 2016年5月3日  下午2:49:08
 */
public class TestJdkProxy {
	public static void main(String[] args) {
		IOffer offer = (IOffer) new ProxyFactory().bind(new OfferImpl());
		offer.postOffer();
	}
}

package com.spring.aop;

public class OfferImpl implements IOffer{

	@Override
	public void postOffer() {
		System.out.println("postOffer");
	}

	@Override
	public void modifyOffer() {
		System.out.println("modifyOffer");
	}

}

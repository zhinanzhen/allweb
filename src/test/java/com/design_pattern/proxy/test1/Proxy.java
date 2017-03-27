package com.design_pattern.proxy.test1;

/**
 * 此代理对象实现了与真实代理相同的接口，如果不同的真实类实现了不同的接口，那么代理类将很多，此方法不灵活---静态代理
 * @author xxn
 * @date 2016年1月18日  下午12:06:12
 */
public class Proxy implements Sourceable{
	private Source source;
	
	public Proxy() {
		super();
		this.source = new Source();
	}

	@Override
	public void method() {
		befor();
		source.method();
		after();
	}

	private void after() {
		System.out.println("after");
	}

	private void befor() {
		System.out.println("befor");
	}

}

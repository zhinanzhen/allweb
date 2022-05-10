package com.design_pattern.proxy.test2;

/**
 * 装饰器模式：能动态的新增或组合对象的行为
 * 代理模式：为其他对象提供一种代理以控制对这个对象的访问
 * 装饰模式是“新增行为”，而代理模式是“控制访问”。关键就是我们如何判断是“新增行 为”还是“控制访问”。你在一个地方写装饰，大家就知道这是在增加功能，你写代理，大 家就知道是在限制。
 * @author xxn
 * @date 2016年1月18日  下午1:21:32
 */
public class Client {
	public static void main(String[] args) {
		BusinessBar bar = new BusinessBarImpl();
		BusinessBar pbar = (BusinessBar)BusiProxy.factory(bar);
		String reBar = pbar.bar("123");
		System.out.println(reBar);

		String reBar2 = pbar.bar2("13");
		System.out.println(reBar2);
		
//		BusinessFoo foo = new BusinessFooImpl();
//		BusinessFoo pfoo = (BusinessFoo) BusiProxy.factory(foo);
//		pfoo.foo();
	}
}

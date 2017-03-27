package com.design_pattern.factory.abstracefactory;

/**
 *
 * 抽象工厂：多个抽象产品类，派生出多个具体产品类；一个抽象工厂类，派生出多个具体工厂类；每个具体工厂类可创建多个具体产品类的实例。
 * 即提供一个创建一系列相关或相互依赖对象的接口，而无需指定他们的具体的类。“一对多”的关系。
 * @author xxn
 * @date 2016年2月19日  上午10:22:56
 */
public class Client {
	public static void main(String[] args) {
		Factory1 f1 = new CreateFacroty1();
		IProductA productA1 = f1.getProductA1();
		productA1.method();
		IProductB productB1 = f1.getProductB1();
		productB1.method();
		
		Factory2 f2 = new CreateFacroty2();
		IProductA productA2 = f2.getProductA2();
		productA2.method();
		IProductB productB2 = f2.getProductB2();
		productB2.method();
		
	}
}

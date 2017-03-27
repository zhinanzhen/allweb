package com.design_pattern.dercorator.monkey;

/**
 * 装饰模式比继承要灵活。避免了继承体系臃肿。 而且降低了类于类之间的关系。
 * 装饰类因为增强已有对象，具备的功能和已有的是相同的，只不过提供了更强功能。
 * 所以装饰类和被装饰类通常是都属于一个体系中的
 * 
 * @author xxn
 * @date 2016年4月27日 上午11:12:39
 */
public class Rabbit extends Monkey {
	@Override
	public void move() {
		super.move();
		run();
	}

	public void run() {
		System.out.println("rabbit run");
	}
}

package com.design_pattern.dercorator;

/**
 * 装饰角色
 * 持有一个构件(Component)对象的实例，并定义一个与抽象构件接口一致的接口
 * @author xxn
 * @date 2016年8月9日  上午9:44:34
 */
public class Decorator extends Component{
	private Component component;
	
	public Decorator(Component component) {
		super();
		this.component = component;
	}
	@Override
	public void operation() {
		component.operation();
	}
}

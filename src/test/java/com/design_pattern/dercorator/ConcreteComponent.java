package com.design_pattern.dercorator;

/**
 * 具体构件(ConcreteComponent)角色
 * 定义一个将要接收附加责任的类
 * @author xxn
 * @date 2016年8月9日  上午9:45:19
 */
public class ConcreteComponent extends Component {

	@Override
	public void operation() {
		System.out.println("people");
	}
	
}

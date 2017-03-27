package com.design_pattern.strategy;

/**
 * 　环境角色类
 * @author xxn
 * @date 2015年12月21日  下午2:23:38
 */
public class Context {
	//持有一个具体策略的对象
	private Strategy strategy;
	/**
     * 构造函数，传入一个具体策略对象
     * @param strategy    具体策略对象
     */
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

    /**
     * 策略方法
     */
	public void contextMethod(){
		strategy.strategyInterface();
	}
}

package com.design_pattern.adapter.cls;

/**
 * 类适配模式呢？很显然的，Adapter类继承了Person类，而在Java这种单继承的语言中也就意味着，他不可能再去继承其他的类了，
 * 这样也就是这个适配器只为Person这一个类服务。所以称其为类适配模式
 * 
 * @author xxn
 * @date 2016年1月28日 下午3:07:52
 */
public class Adapter extends Person implements Job {

	@Override
	public void speakFrench() {

	}

}

package com.design_pattern.adapter.obj;

import com.design_pattern.adapter.cls.Job;
import com.design_pattern.adapter.cls.Person;

/**
 * 对象的适配器模式，把“源”作为一个构造参数传入适配器，然后执行接口所要求的方法。这种适配模式可以为多个源进行适配。弥补了类适配模式的不足。
 * 
 * @author xxn
 * @date 2016年1月28日 下午3:09:09
 */
public class Adapter implements Job {
	Person person;

	public Adapter(Person person) {
		this.person = person;
	}

	public void speakEnglish() {
		person.speakEnglish();
	}

	public void speakJapanese() {
		person.speakJapanese();
	}

	@Override
	public void speakFrench() {

	}
}

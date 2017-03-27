package com.design_pattern.factory.simplefactory;

/**
 * 工厂角色
 * @author xxn
 * @date 2016年2月18日  上午10:51:08
 */
public class Factory {
	public static MethodInter getInstance(String str){
		if("A".equals(str)){
			return new A();
		}else if("B".equals(str)){
			return new B();
		}else{
			return null;
		}
	}
}

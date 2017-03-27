package com.design_pattern.bridge.test1;

/**
 * 将抽象部分与实现部分分离，使它们都可以独立的变化
 * @author xxn
 * @date 2016年1月18日  下午4:04:37
 */
public class BridgeTest {
	public static void main(String[] args) {
		Bridge bridge = new MyBridge();
		SourceAble source1 = new SourceSub1();
		bridge.setSource(source1);
		bridge.method();
		
		SourceAble source2 = new SourceSub2();
		bridge.setSource(source2);
		bridge.method();
	}
}

package com.foundation.callback.demo;

/**
 * 回调：一种双向调用模式，也就是说，被调用方在接口被调用时也会调用对方的接口；
 * 
 * @author xxn
 * @date 2016年2月17日 下午4:38:00
 */
public class KongNet implements ServiceProvider {
	public void customHint() {
		System.out.println("优惠活动开始啦，即日起登陆空中网就有好礼送！ 详情见网站公告。");
	}

	public void init() {
		ChinaTelecom ct = new ChinaTelecom();
		ct.setSp(new KongNet());// 告诉ChinaTelecom这是哪家sp
		// KongNet（也就是当前类）实现了ServiceProvider，因此就能把当前类作为适合
		// ChinaTelecom.setSp()的参数，可以修改为ct.setSP(this);
		ct.init();
	}

	public static void main(String[] args) {
		KongNet sp = new KongNet();
		sp.init();
	}
}

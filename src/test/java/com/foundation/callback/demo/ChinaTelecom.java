package com.foundation.callback.demo;

public class ChinaTelecom {
	 private ServiceProvider sp;//callback接口作为属性

	    public void setSp(ServiceProvider sp) {
	        this.sp = sp;
	    }
	    
	    public void init(){
	        System.out.println("Welcome, This is ChinaTelecom! ");
	        sp.customHint();//sp自定义的操作
	    }
}

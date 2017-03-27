package com.foundation.callback;

public class Employee {
	private CallBackInterface callBack = null;

	public void doSome(){  
        //1.开始干活了  
        for(int i=0;i<10;i++){  
            System.out.println("第【" + i + "】事情干完了！");  
        }  
          
        //2.告诉老板干完了  
        callBack.execute();  
    }  
	
	public CallBackInterface getCallBack() {
		return callBack;
	}

	public void setCallBack(CallBackInterface callBack) {
		this.callBack = callBack;
	}
	
}

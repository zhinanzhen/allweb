package com.thinkinginjava.exception.test1;

@SuppressWarnings("serial")
public class MyException extends RuntimeException{
	public MyException(){
		
	}
	
	public MyException(String str){
		super(str);
	}
}

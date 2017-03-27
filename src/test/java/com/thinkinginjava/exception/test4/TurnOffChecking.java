package com.thinkinginjava.exception.test4;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.sun.star.uno.RuntimeException;

public class TurnOffChecking {
	public static void main(String[] args) {
		WrapCheckedException wce = new WrapCheckedException();
		for (int i = 0; i < 4; i++) {
			try {
				if(i<3){
					wce.throwRuntimeException(i);
				}else{
					throw new SomeOtherException();
				}
			} catch (SomeOtherException se) {
				System.out.println("SomeOtherException" + se);
			} catch (RuntimeException e){
				try {
					throw e.getCause();
				} catch (FileNotFoundException fe) {
					System.out.println("FileNotFoundException:" + fe);
				} catch (IOException ie) {
					System.out.println("IOException:" + ie);
				} catch (Throwable te) {
					System.out.println("Throwable:" + te);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
@SuppressWarnings("serial")
class SomeOtherException extends Exception {}
class WrapCheckedException{
	void throwRuntimeException(int type) throws Exception{
		switch(type){
			case 0:throw new FileNotFoundException();
			case 1:throw new IOException();
			case 2:throw new RuntimeException("where am i?");
			default:return;
		}
	}
}
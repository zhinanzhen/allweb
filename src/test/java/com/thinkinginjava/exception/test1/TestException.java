package com.thinkinginjava.exception.test1;

import org.springframework.util.Assert;

public class TestException {
	public static void f() throws MyException{
		System.out.println("f()");
		throw new MyException();
	}
	
	public static void g() throws MyException{
		System.out.println("g()");
		throw new MyException("params");
	}
	public static void say(){            //new NullPointerException
        System.err.println("say>>>>");
        throw new NullPointerException();
    }
	public static void sayss(){     
		says();
	}
	public static void says(){     
		say();
	}
	public static void main(String[] args) {
//			Assert.notNull(null);
			sayss();
	}
}

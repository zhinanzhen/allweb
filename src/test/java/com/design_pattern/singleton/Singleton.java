package com.design_pattern.singleton;

public class Singleton {
//	private static Singleton singleton=new Singleton();
	private Singleton(){}
	
	private static class SingletonFactory {
		static{
			System.out.println("create instance");
		}
		private static Singleton instance = new Singleton();  
	}
	public static Singleton getSingleton(){
		return SingletonFactory.instance;
	}
	
	/*public synchronized static Singleton getSingleton(){
		if(singleton == null){
			 synchronized(singleton){
				 if(singleton == null){
					 singleton = new Singleton();
					 System.out.println("haha: "+singleton);
				 }
			 }
		}
		return singleton;
	}*/
	
	/*public synchronized static Singleton getSingleton(){
		if(singleton == null){
			singleton = new Singleton();
			System.out.println("haha: "+singleton);
		}
		return singleton;
	}*/
	
	/*
	public static Singleton getSingleton(){
		if(singleton == null){
			singleton = new Singleton();
			System.out.println("haha: "+singleton);
		}
		return singleton;
	}
 */
	
}

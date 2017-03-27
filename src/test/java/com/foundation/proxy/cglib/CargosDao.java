package com.foundation.proxy.cglib;

public class CargosDao implements IDao{
	public void insert(String name){
		System.out.println("cargosDao" + name);
	}
}

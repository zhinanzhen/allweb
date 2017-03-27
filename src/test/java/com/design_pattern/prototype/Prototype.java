package com.design_pattern.prototype;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 不好用
 * 原型模式虽然是创建型的模式，但是与工程模式没有关系，从名字即可看出，该模式的思想就是将一个对象作为原型，
 * 对其进行复制、克隆，产生一个和原对象类似的新对象
 * @author xxn
 * @date 2016年1月11日  上午9:53:18
 */
public class Prototype implements Cloneable,Serializable{
	private Object obj;
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return (Prototype)super.clone();
	}
	public Object deepClone() throws IOException, ClassNotFoundException{
		File file = new File("A.out");
		FileOutputStream bout = new FileOutputStream(file);
		ObjectOutputStream oout = new ObjectOutputStream(bout);
		oout.writeObject(obj);
		oout.flush();
		oout.close();
		
		FileInputStream bin = new FileInputStream(file);
		ObjectInputStream oin = new ObjectInputStream(bin);
		Object readObject = oin.readObject();
		oin.close();
		return readObject;
	}
	
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public static void main(String[] args) throws ClassNotFoundException, IOException, CloneNotSupportedException {
		Prototype p = new Prototype();
		A a = new A();
		B b = new B();
		b.setValue("xu");
		a.setB(b);
		a.setName("ddd");
		p.setObj(a);
		A aa = (A) a.clone();
//		A aa = (A) p.deepClone();
		System.out.println("===========================");
		System.out.println(aa.getB() == b);
		
		
	}
}

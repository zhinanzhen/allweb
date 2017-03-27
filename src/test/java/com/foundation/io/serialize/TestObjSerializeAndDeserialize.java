package com.foundation.io.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestObjSerializeAndDeserialize {
	public static void main(String[] args) {
		serializePerson();
		Person p = deSerializePerson();
		System.out.println(p.getAge()+":" + p.getName());
	}

	private static void serializePerson() {
		Person p = new Person();
		p.setAge(22);
		p.setName("xx");
		p.setSex("boy");
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(new File("E:/person.txt")));
			out.writeObject(p);
			System.out.println("对象序列化成功");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static Person deSerializePerson(){
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(new File("E:/person.txt")));
			Person	p = (Person) in.readObject();
			System.out.println("Person对象反序列化成功！");
			return p;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				if(in != null){
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}

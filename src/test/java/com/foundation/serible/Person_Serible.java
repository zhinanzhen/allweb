package com.foundation.serible;

import java.io.IOException;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Person_Serible extends Person implements Serializable {
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();// 先序列化对象
		out.writeUTF(super.getName());// 再序列化父类的域
		out.writeInt(super.getAge());// 再序列化父类的域
	}

	private void readObject(java.io.ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();// 先反序列化对象
		super.setName(in.readUTF());// 再反序列化父类的域
		super.setAge(in.readInt());// 再反序列化父类的域
	}
}

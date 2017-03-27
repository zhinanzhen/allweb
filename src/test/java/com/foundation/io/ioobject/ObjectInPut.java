package com.foundation.io.ioobject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import com.app.showpic.register.bean.User;

public class ObjectInPut {
	public static void main(String[] args) {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream("D:acx.txt"));
			@SuppressWarnings("unchecked")
			List<User> readObject = (List<User>) in.readObject();
			for (User user : readObject) {
				System.out.println(user);
			}
		} catch (IOException | ClassNotFoundException e) {
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
	}
}

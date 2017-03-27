package com.foundation.io.ioobject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.app.showpic.register.bean.User;

public class ObjectOutput {
	public static void main(String[] args) throws FileNotFoundException {
		List<User> list = new ArrayList<User>();
		User user = new User();
		user.setCreateDate(new Date());
		user.setEmail("xu@163.com");
		user.setPhone("13899403332");
		user.setSex("1");
		user.setState("1");
		user.setUserCode("xu303");
		user.setUserDesc("客户");
		user.setUserId(1234444);
		user.setUserName("徐");
		user.setUserPwd("123456");
		list.add(user);
		
		user = new User();
		user.setCreateDate(new Date());
		user.setEmail("xu@163.com");
		user.setPhone("13899403332");
		user.setSex("1");
		user.setState("1");
		user.setUserCode("xu303");
		user.setUserDesc("客户");
		user.setUserId(1234445);
		user.setUserName("徐");
		user.setUserPwd("123456");
		list.add(user);
		
		user = new User();
		user.setCreateDate(new Date());
		user.setEmail("xu@163.com");
		user.setPhone("13899403332");
		user.setSex("1");
		user.setState("1");
		user.setUserCode("xu303");
		user.setUserDesc("客户");
		user.setUserId(1234446);
		user.setUserName("徐");
		user.setUserPwd("123456");
		list.add(user);
		
		ObjectOutputStream ois = null;
		try {
			ois = new ObjectOutputStream(new FileOutputStream("D:acx.txt"));
			ois.writeObject(list);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ois != null){
					ois.flush();
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

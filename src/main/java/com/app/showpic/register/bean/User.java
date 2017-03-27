package com.app.showpic.register.bean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private static final long serialVersionUID = 3941740210014427004L;
	private int userId;      //用户Id
	private String userCode; //用户编码：登陆号
	private String userPwd; //登陆密码
	private String userName; // 用户名
	private String sex;      //用户性别
	private String userDesc; //用户描述
	private String email;	//用户em
	private String phone;	//用户电话号码
	private Date createDate;//用户创建日期
	private String state;   //用户状态 ，OOA:有效，OOB：无效

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUserDesc() {
		return userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		
		return "userId[" + this.userId +
		"],userCode[" + this.userCode +
		"],userPwd[" + this.userPwd +
		"],userName[" + this.userName +
		"],sex[" + this.sex +
		"],userDesc[" + this.userDesc +
		"],email[" + this.email +
		"],phone[" + this.phone +
		"],createDate[" + this.createDate +
		"],state[" + this.state ;
	}
}

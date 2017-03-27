package com.app.common.utils.xml;

import java.util.List;

public class Abc {
	private String name ;
	private String age;
	private String addre;
	private boolean success;
	private List<Child> childs;
	private List<Hae> haes;
	private You you;
	
	public You getYou() {
		return you;
	}
	public void setYou(You you) {
		this.you = you;
	}
	public List<Hae> getHaes() {
		return haes;
	}
	public void setHaes(List<Hae> haes) {
		this.haes = haes;
	}
	public List<Child> getChilds() {
		return childs;
	}
	public void setChilds(List<Child> childs) {
		this.childs = childs;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddre() {
		return addre;
	}
	public void setAddre(String addre) {
		this.addre = addre;
	}
	
}

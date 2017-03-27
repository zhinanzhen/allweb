package com.design_pattern.memento;

public class Original {
	private String value;
	private int num;
	
	public Memento createMemento(){
		return new Memento(this.value);
	}
	
	public void restoreMemento(Memento memento){
		this.value = memento.getValue();
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}

package com.design_pattern.adapter.cls;

public class Person {
    private String name;  
    private String sex;  
    private int age;
    public void speakJapanese(){  
        System.out.println("I can speak Japanese!");  
    }  
      
    public void speakEnglish(){  
        System.out.println("I can speak English!");  
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
    
}

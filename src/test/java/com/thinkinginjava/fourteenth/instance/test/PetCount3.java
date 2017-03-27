package com.thinkinginjava.fourteenth.instance.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.design_pattern.adapter.cls.Person;
import com.thinkinginjava.fourteenth.instance.Pet;

public class PetCount3 extends HashMap<Class<? extends Pet>, Integer>{
	public static void main(String[] args) {
//		System.out.println(Pet.class.isAssignableFrom(Cat.class));
		List<Person> list = new ArrayList();
		Person p = new Person();
		list.add(p);
		p.setAge(12);
		System.out.println((list.get(0)).getAge());
	}
}

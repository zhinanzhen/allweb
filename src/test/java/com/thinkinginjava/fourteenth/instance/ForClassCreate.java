package com.thinkinginjava.fourteenth.instance;

import java.util.ArrayList;
import java.util.List;

public class ForClassCreate extends PetCreator {
//	private static List<Class<? extends Pet>> petClass = Collections.unmodifiableList(Arrays.asList(Pet.class,Cat.class,Dog.class));
	private static List<Class<? extends Pet>> petClass = new ArrayList<>();
	static {
		petClass.add(Cat.class);
	}
	@Override
	public List<Class<? extends Pet>> types() {
		return petClass;
	}
	public static void main(String[] args) {
		List<? super Number> list=new ArrayList<Number>();
        list.add(2.0);
        list.add(3.0);
	}
	
	public <T extends Pet> Pet createPet(){
		return new Cat();
	}
}

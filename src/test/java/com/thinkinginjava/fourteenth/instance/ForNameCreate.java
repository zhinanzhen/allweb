package com.thinkinginjava.fourteenth.instance;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class ForNameCreate extends PetCreator {
	private static List<Class<? extends Pet>> pets = new ArrayList<>();
	private static String[] names = {"com.thinkinginjava.fourteenth.instance.Pet",
		"com.thinkinginjava.fourteenth.instance.Cat","com.thinkinginjava.fourteenth.instance.Dog"};
	static{
		for (String name : names) {
			try {
				pets.add((Class<? extends Pet>) Class.forName(name));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public List<Class<? extends Pet>> types() {
		return pets;
	}

}

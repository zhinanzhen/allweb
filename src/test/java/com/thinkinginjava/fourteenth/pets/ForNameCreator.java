//: typeinfo/pets/ForNameCreator.java
package com.thinkinginjava.fourteenth.pets;

import java.util.*;

public class ForNameCreator extends PetCreator {
	private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
	// Types that you want to be randomly created:
	private static String[] typeNames = { "com.thinkinginjava.fourteenth.pets.Mutt",
			"com.thinkinginjava.fourteenth.pets.Pug", "com.thinkinginjava.fourteenth.pets.EgyptianMau",
			"com.thinkinginjava.fourteenth.pets.Manx", "com.thinkinginjava.fourteenth.pets.Cymric", "com.thinkinginjava.fourteenth.pets.Rat",
			"com.thinkinginjava.fourteenth.pets.Mouse", "com.thinkinginjava.fourteenth.pets.Hamster" };

	@SuppressWarnings("unchecked")
	private static void loader() {
		try {
			for (String name : typeNames)
				types.add((Class<? extends Pet>) Class.forName(name));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	static {
		loader();
	}

	public List<Class<? extends Pet>> types() {
		return types;
	}
} // /:~

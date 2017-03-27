//: typeinfo/pets/LiteralPetCreator.java
// Using class literals.
package com.thinkinginjava.fourteenth.pets;

import java.util.*;

public class LiteralPetCreator extends PetCreator {
	// 编译器常量
	public static final List<Class<? extends Pet>> allTypes = Collections
			.unmodifiableList(Arrays.asList(Pet.class, Dog.class, Cat_Pet.class,
					Rodent.class, Mutt.class, Pug.class, EgyptianMau.class,
					Manx.class, Cymric.class, Rat.class, Mouse.class,
					Hamster.class));
	private static final List<Class<? extends Pet>> types = allTypes.subList(
			allTypes.indexOf(Mutt.class), allTypes.size());

	public List<Class<? extends Pet>> types() {
		return types;
	}

	public static void main(String[] args) {
		new ArrayList();
		allTypes.add(Dog.class);
		System.out.println(allTypes.size());
		System.out.println(types.size());
	}
}

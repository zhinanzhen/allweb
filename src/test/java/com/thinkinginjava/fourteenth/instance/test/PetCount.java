package com.thinkinginjava.fourteenth.instance.test;

import java.util.HashMap;

import com.thinkinginjava.fourteenth.instance.Cat;
import com.thinkinginjava.fourteenth.instance.Dog;
import com.thinkinginjava.fourteenth.instance.ForNameCreate;
import com.thinkinginjava.fourteenth.instance.Pet;
import com.thinkinginjava.fourteenth.instance.PetCreator;

public class PetCount {
	@SuppressWarnings("serial")
	static  class PetCounter extends HashMap<String, Integer>{
		public void count(String type){
			Integer integer = get(type);
			if(integer == null){
				put(type,1);
			}else{
				put(type,integer + 1);
			}
		}
	}
	
	public static void countPets(PetCreator creator){
		PetCounter counter = new PetCounter();
		Pet[] createArray = creator.createArray(20);
		for (Pet pet : createArray) {
			System.out.print(pet.getClass().getSimpleName() +" ");
			if(pet instanceof Cat){
				counter.count("Cat");
				continue;
			}
			if(pet instanceof Dog){
				counter.count("Dog");
				continue;
			}
			if(pet instanceof Pet){
				counter.count("Pet");
			}
		}
		System.out.println();
		System.out.println(counter);
	}
	public static void main(String[] args) {
		countPets(new ForNameCreate());
	}
}

package com.thinkinginjava.fourteenth.instance.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.thinkinginjava.fourteenth.instance.Cat;
import com.thinkinginjava.fourteenth.instance.Dog;
import com.thinkinginjava.fourteenth.instance.ForNameCreate;
import com.thinkinginjava.fourteenth.instance.Pet;

public class PetCount2 {
	private static final List<Class<? extends Pet>> petClass = Collections.unmodifiableList(Arrays.asList(Cat.class,Dog.class,Pet.class));
	@SuppressWarnings("serial")
	static class PetCounter extends LinkedHashMap<Class<? extends Pet> , Integer>{
		PetCounter(){
			for (Class<? extends Pet> petcls : petClass) {
				put(petcls, 0);
			}
		}
		public void counter(Pet pet){
			for (Map.Entry<Class<? extends Pet>,Integer> entry: entrySet()) {
				if (entry.getKey().isInstance(pet)) {
					put(entry.getKey(),entry.getValue()+1);
				}
			}
		}
		@Override
		public String toString() {
			StringBuilder strb = new StringBuilder("{");
			Iterator<java.util.Map.Entry<Class<? extends Pet>, Integer>> iterator = entrySet().iterator();
			for(;;){
				java.util.Map.Entry<Class<? extends Pet>, Integer> next = iterator.next();
				strb.append(next.getKey().getSimpleName());
				strb.append("=");
				strb.append(next.getValue());
				if(!iterator.hasNext()){
					strb.append("}");
					break;
				}
				strb.append(",");
			}
			return strb.toString();
		}
	}
	
	public static void main(String[] args) {
		PetCounter petCounter = new PetCounter();
		Pet[] createArray = new ForNameCreate().createArray(20);
		for (Pet pet : createArray) {
			petCounter.counter(pet);
		}
		System.out.println(petCounter);
		
	}
}

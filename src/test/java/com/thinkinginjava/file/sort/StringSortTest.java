package com.thinkinginjava.file.sort;

import java.util.Enumeration;

public class StringSortTest {
	static class StringCompare implements Compare{

		@Override
		public boolean lessThan(Object l, Object r) {
			return ((String)l).toLowerCase().compareTo(((String)r).toLowerCase()) < 0;
		}

		@Override
		public boolean lessThanOrEqual(Object l, Object r) {
			return ((String)l).toLowerCase().compareTo(((String)r).toLowerCase()) <= 0;
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		SortVector sv = new SortVector(new StringCompare());
		sv.addElement("r");
		sv.addElement("R");
		sv.addElement("e");
		sv.addElement("8");
		sv.addElement("y");
		sv.addElement("a");
		sv.sort();
		Enumeration elements = sv.elements();
		while (elements.hasMoreElements()) {
			Object object = (Object) elements.nextElement();
			System.out.println(object);
		}
	}
}

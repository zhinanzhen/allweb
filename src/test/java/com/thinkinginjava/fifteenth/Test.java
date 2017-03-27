package com.thinkinginjava.fifteenth;

import com.thinkinginjava.fourteenth.instance.Cat;

public class Test {
	public static void main(String[] args) {
		TwoTuble<String, Cat> tt = new TwoTuble<String, Cat>("123", new Cat("xyxy"));
		Cat b = tt.b;
		b.setName("23444");
	}
}

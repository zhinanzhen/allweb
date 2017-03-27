package com.design_pattern.dercorator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Dtest {
	public static void main(String[] args) {
//		Component component = new ConcreteComponent();
//		Component decoratorA = new ConcreteDecoratorA(component);
//		Component decoratorB = new ConcreteDecoratorB(decoratorA);
//		decoratorB.operation();
		Component decoratorB = new ConcreteDecoratorB(new ConcreteDecoratorA(new ConcreteComponent()));
		decoratorB.operation();
		
		File file = new File("");
		try {
			InputStream inputStream = new FileInputStream(file);
			Reader reader = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(reader);
			br.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

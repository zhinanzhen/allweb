package com.classloader.test1;

import java.io.IOException;
import java.io.InputStream;


public class TestCL {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		ClassLoader mycl = new ClassLoader(){
			@Override
			public Class<?> loadClass(String name)throws ClassNotFoundException {
				try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(fileName);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);   
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
			}
		};
		Object object = TestCL.class.getClassLoader().loadClass("com.classloader.test1.TestCL").newInstance();
		System.out.println(object.getClass());
		
		Object object2 = mycl.loadClass("com.classloader.test1.TestCL").newInstance();
		System.out.println(object2.getClass());
		
	}
}

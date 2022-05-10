package com.reflect;

import java.lang.reflect.Method;

/**
 * @ClassName ReflectTest
 * @Description
 * @Author xiangnan.xu
 * @DATE 2018/3/23 15:33
 */
public class ReflectTest {
    public static void main(String[] args) {
        Method[] methods = ReflectB.class.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());
        }
    }
}

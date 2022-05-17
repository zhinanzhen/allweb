package com.foundation.jvm.classloader;

/**
 * @ClassName ClassLoaderTest
 * @Description
 * @Author xuxiangnan
 * @Date 2022/5/10 14:22
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        A a = new A();
        a.add();
    }
}
class A {
    static {
        System.out.println(44444444);
    }
    public void add(){

    }
}

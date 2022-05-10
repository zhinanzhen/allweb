package com.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * @ClassName JolTest
 * @Description
 * @Author xuxiangnan
 * @Date 2021/10/27 14:16
 */
public class JolTest {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        synchronized (a){
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
        }
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }
}
class A{
   /* int a;
    long b;
    boolean m;
    JolTest jolTest = new JolTest();*/
}
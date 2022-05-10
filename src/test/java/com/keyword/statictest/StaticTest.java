package com.keyword.statictest;

/**
 * @ClassName StaticTest
 * @Description
 * @Author xuxiangnan
 * @Date 2021/6/6 9:42
 */
public class StaticTest {
    public static void main(String[] args) {
        Static1 s1 = new Static1();
        s1.setSb("333");
        System.out.println(s1.getSb());


        Static1 s2 = new Static1();
        s2.setSb("4444");
        System.out.println(s2.getSb());
    }
}

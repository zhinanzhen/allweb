package com.test;

import java.io.*;

/**
 * @ClassName CC
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/11/1 16:55
 */
public class CC implements Serializable {

    private static final long serialVersionUID = 8896721981382602526L;
    private String a;

    private transient String b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public static void main(String[] args) throws Exception{
        CC c = new CC();
        c.setA("aaa");
        c.setB("b");

//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:\\bb.txt"),true));
//        oos.writeObject(c);
//        oos.flush();
//        oos.close();
//
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:\\bb.txt")));
//        CC o = (CC)ois.readObject();
//        System.out.println(o.getA());
//        System.out.println(o.getB());
        c.aa(c);
    }

    public void aa(Object obj){
        System.out.println(obj.getClass().getSimpleName());
    }
}

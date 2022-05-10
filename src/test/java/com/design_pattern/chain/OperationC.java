package com.design_pattern.chain;

/**
 * @ClassName OperationC
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/10/30 17:59
 */
public class OperationC extends Handle {
    @Override
    public void doSomething(int a) {
        if(a > 30){
            System.out.println("a > 30");
        }
    }
}

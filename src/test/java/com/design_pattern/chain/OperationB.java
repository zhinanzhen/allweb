package com.design_pattern.chain;

/**
 * @ClassName OperationB
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/10/30 17:57
 */
public class OperationB extends Handle{
    @Override
    public void doSomething(int a) {
        if(a > 20 && a < 30){
            System.out.println("a > 20 && a < 30");
        }else{
            operation.doSomething(a);
        }
    }
}

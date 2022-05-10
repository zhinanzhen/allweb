package com.design_pattern.chain;

/**
 * @ClassName OperationA
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/10/30 17:50
 */
public class OperationA extends Handle{
    @Override
    public void doSomething(int a) {
        if(a > 10 && a < 20){
            System.out.println("a > 10 && a < 20");
        }else{
            operation.doSomething(a);
        }
    }
}

package com.design_pattern.chain;

/**
 * @ClassName Test
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/10/30 17:59
 */
public class Test {
    public static void main(String[] args) {
        Handle handleA = new OperationA();
        Handle handleB = new OperationB();
        Handle handleC = new OperationC();
        handleA.setOperation(handleB);
        handleB.setOperation(handleC);

        handleA.doSomething(14);
    }
}

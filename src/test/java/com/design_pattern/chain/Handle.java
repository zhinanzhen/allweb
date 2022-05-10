package com.design_pattern.chain;

/**
 * @ClassName Handle
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/10/30 17:46
 */
public abstract class Handle {
    protected Handle operation;
    public void setOperation(Handle operation){
        this.operation = operation;
    }

    public abstract void doSomething(int a);
}

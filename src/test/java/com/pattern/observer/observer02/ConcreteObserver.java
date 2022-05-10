package com.pattern.observer.observer02;

/**
 * @ClassName ConcreteObserver
 * @Description
 * @Author xuxiangnan
 * @Date 2021/4/10 13:38
 */
public class ConcreteObserver implements Observer {
    //观察者的状态
    private String observerState;

    @Override
    public void update(Subject subject) {
        /**
         * 更新观察者的状态，使其与目标的状态保持一致
         */
        observerState = ((ConcreteSubject)subject).getState();
        System.out.println("观察者状态为："+observerState);
    }
}

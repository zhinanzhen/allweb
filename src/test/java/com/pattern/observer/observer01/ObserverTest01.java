package com.pattern.observer.observer01;

/**
 * @ClassName ObserverTest01
 * @Description
 * @Author xuxiangnan
 * @Date 2021/4/10 13:32
 */
public class ObserverTest01 {
    public static void main(String[] args) {
        //创建主题对象
        ConcreteSubject subject = new ConcreteSubject();
        //创建观察者对象
        Observer observer = new ConcreteObserver();
        //将观察者对象登记到主题对象上
        subject.attach(observer);
        //改变主题对象的状态
        subject.change("new state");
    }
}

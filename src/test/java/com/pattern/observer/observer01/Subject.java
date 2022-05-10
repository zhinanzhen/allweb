package com.pattern.observer.observer01;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Subject
 * @Description
 * @Author xuxiangnan
 * @Date 2021/4/10 13:28
 */
public class Subject {
    private List<Observer> list = new ArrayList<Observer>();
    public void attach(Observer observer){
        list.add(observer);
        System.out.println("Attached an observer");
    }
    public void detach(Observer observer){
        list.remove(observer);
    }

    public void nodifyObservers(String newState){
        for(Observer observer : list){
            observer.update(newState);
        }
    }

}

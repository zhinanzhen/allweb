package com.test;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * @ClassName ArraysTest
 * @Description
 * @Author xuxiangnan
 * @Date 2019/4/23 10:09
 */
public class ArraysTest {
    public static void main(String[] args) {
        NavigableSet<Integer> sortedTreeSet = new TreeSet<Integer>();
        sortedTreeSet.add(2);
        sortedTreeSet.add(3);
        sortedTreeSet.add(4);
        sortedTreeSet.add(5);

        System.out.println(sortedTreeSet.size());
        System.out.println( sortedTreeSet.ceiling(0));
    }

    private void array(){
        Plate<? extends Fruit> plate = new Plate<Apple>(new Apple());
        Fruit item = plate.getItem();


        Plate<? extends Fruit> plate2 = new Plate<Banana>(new Banana());


        Plate<?> plate3 = new Plate<>(new Apple());
        Object item1 = plate3.getItem();


        Plate<? super Fruit> plate4 = new Plate<Fruit>(new Banana());
        plate4.setItem(new Apple());
        Apple item2 = (Apple)plate4.getItem();
    }
}
class Food{}

class Meat extends Food{}
class Beef extends Meat{}
class Pork extends Meat{}

class Fruit extends Food{}
class Apple extends Fruit{}
class Banana extends Fruit{}

class Plate<T>{
    private T item;
    public Plate(){
    }
    public Plate(T item){
        this.item = item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}


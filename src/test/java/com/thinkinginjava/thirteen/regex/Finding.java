package com.thinkinginjava.thirteen.regex;
//: strings/Finding.java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finding {
  public static void main(String[] args) {
    Matcher m = Pattern.compile("\\w+")
      .matcher("Evening is full of the linnet's wings");
    while(m.find())
      System.out.println(m.group() + " ");
    System.out.println();
    int i = 0;
    while(m.find(i)) {
    	 System.out.println(m.group() + " ");
      i++;
    }
  }
} /* Output:
Evening is full of the linnet s wings
Evening vening ening ning ing ng g is is s full full ull ll l of of f the the he e linnet linnet innet nnet net et t s s wings wings ings ngs gs s
*///:~

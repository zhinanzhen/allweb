package com.keyword.finaltest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Final1
 * @Description
 * @Author xuxiangnan
 * @Date 2021/6/6 9:40
 */
public class Final1 {
    private final AFinal strArr;

    public Final1(){
        this.strArr = new AFinal();
    }

    public void put(){

    }

    public AFinal getStrArr() {
        final AFinal strArrM = this.strArr;
        return strArrM;
    }
}

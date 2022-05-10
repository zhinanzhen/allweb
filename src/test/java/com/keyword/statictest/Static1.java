package com.keyword.statictest;

import lombok.Data;

/**
 * @ClassName Static1
 * @Description
 * @Author xuxiangnan
 * @Date 2021/6/6 9:41
 */
@Data
public class Static1 {
    private static StringBuilder sb = new StringBuilder();

    public static void setSb(String name){
        sb.append(name);
    }

    public static String getSb(){
        return sb.toString();
    }
}

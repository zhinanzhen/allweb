package com.pattern.chain.chain02;

import com.pattern.chain.PreparationList;
import com.pattern.chain.Student;

/**
 * @ClassName ChainTest01
 * @Description
 * @Author xuxiangnan
 * @Date 2021/4/10 11:21
 */
public class ChainTest02 {
    public static void main(String[] args) {
        PreparationList preparationList = new PreparationList();
        preparationList.setWashFace(true);
        preparationList.setWashHair(true);
        preparationList.setHaveBreakfast(true);

        Student student = new Student();
        FilterChain filterChain = new FilterChain(student);
        filterChain.addFilter(new WashFaceFilter());
        filterChain.addFilter(new WashHairFilter());
        filterChain.addFilter(new HaveBreakfastFilter());

        filterChain.doFilter(preparationList,filterChain);
    }
}

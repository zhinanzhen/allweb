package com.pattern.chain.chain01;

import com.pattern.chain.PreparationList;
import com.pattern.chain.Student;

/**
 * @ClassName ChainTest01
 * @Description
 * @Author xuxiangnan
 * @Date 2021/4/10 11:21
 */
public class ChainTest01 {
    public static void main(String[] args) {
        PreparationList preparationList = new PreparationList();
        preparationList.setWashFace(true);
        preparationList.setWashHair(true);
        preparationList.setHaveBreakfast(true);

        AbstractPrepareFilter washFaceFilter = new WashFaceFilter(null);
        AbstractPrepareFilter washHairFilter = new WashHairFilter(washFaceFilter);
        AbstractPrepareFilter haveBreakfastFilter = new HaveBreakfastFilter(washHairFilter);

        Student student = new Student();

        haveBreakfastFilter.doFilter(preparationList,student);
    }
}

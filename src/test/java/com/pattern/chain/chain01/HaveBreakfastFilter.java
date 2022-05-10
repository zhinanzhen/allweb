package com.pattern.chain.chain01;

import com.pattern.chain.PreparationList;

/**
 * @ClassName HaveBreakfastFilter
 * @Description
 * @Author xuxiangnan
 * @Date 2021/4/10 11:29
 */
public class HaveBreakfastFilter extends AbstractPrepareFilter {
    public HaveBreakfastFilter(AbstractPrepareFilter nextPrepareFilter){
        super(nextPrepareFilter);
    }
    @Override
    public void prepare(PreparationList preparationList) {
        if(preparationList.isHaveBreakfast()){
            System.out.println("have breakfast");
        }
    }
}

package com.pattern.chain.chain01;

import com.pattern.chain.PreparationList;

/**
 * @ClassName WashHairFilter
 * @Description
 * @Author xuxiangnan
 * @Date 2021/4/10 11:22
 */
public class WashHairFilter extends AbstractPrepareFilter {
    public WashHairFilter(AbstractPrepareFilter nextPrepareFilter){
        super(nextPrepareFilter);
    }
    @Override
    public void prepare(PreparationList preparationList) {
        if (preparationList.isWashHair()) {
            System.out.println("wash hair");
        }
    }
}

package com.pattern.chain.chain01;

import com.pattern.chain.PreparationList;

/**
 * @ClassName WashFaceFilter
 * @Description
 * @Author xuxiangnan
 * @Date 2021/4/10 11:19
 */
public class WashFaceFilter extends AbstractPrepareFilter {
    public WashFaceFilter(AbstractPrepareFilter nextPrepareFilter){
        super(nextPrepareFilter);
    }
    @Override
    public void prepare(PreparationList preparationList) {
        if(preparationList.isWashFace()){
            System.out.println("wash face");
        }
    }
}

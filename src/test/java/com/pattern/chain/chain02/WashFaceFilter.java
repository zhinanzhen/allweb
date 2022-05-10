package com.pattern.chain.chain02;

import com.pattern.chain.PreparationList;

/**
 * @ClassName WashFaceFilter
 * @Description
 * @Author xuxiangnan
 * @Date 2021/4/10 11:19
 */
public class WashFaceFilter implements SudentPrepareFilter {
    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        if(preparationList.isWashFace()){
            System.out.println("wash face");
        }
        filterChain.doFilter(preparationList,filterChain);
    }
}

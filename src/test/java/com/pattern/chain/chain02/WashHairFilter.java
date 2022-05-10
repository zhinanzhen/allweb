package com.pattern.chain.chain02;

import com.pattern.chain.PreparationList;

/**
 * @ClassName WashHairFilter
 * @Description
 * @Author xuxiangnan
 * @Date 2021/4/10 11:22
 */
public class WashHairFilter implements SudentPrepareFilter {
    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        if (preparationList.isWashHair()) {
            System.out.println("wash hair");
        }
        filterChain.doFilter(preparationList,filterChain);
    }
}

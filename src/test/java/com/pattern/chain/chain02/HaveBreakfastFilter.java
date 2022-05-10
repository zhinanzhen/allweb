package com.pattern.chain.chain02;

import com.pattern.chain.PreparationList;

/**
 * @ClassName HaveBreakfastFilter
 * @Description
 * @Author xuxiangnan
 * @Date 2021/4/10 11:42
 */
public class HaveBreakfastFilter implements SudentPrepareFilter {
    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        if(preparationList.isHaveBreakfast()){
            System.out.println("have breakfast");
        }
        filterChain.doFilter(preparationList,filterChain);
    }
}

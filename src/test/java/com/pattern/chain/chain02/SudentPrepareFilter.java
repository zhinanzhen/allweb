package com.pattern.chain.chain02;

import com.pattern.chain.PreparationList;
/**
 * @ClassName SudentPrepareFilter
 * @Description
 * @Author xuxiangnan
 * @Date 2021/4/10 11:35
 */
public interface SudentPrepareFilter {
    void doFilter(PreparationList preparationList, FilterChain filterChain);
}

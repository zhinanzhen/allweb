package com.pattern.chain.chain01;

import com.pattern.chain.PreparationList;
import com.pattern.chain.Student;

/**
 * @ClassName AbstractPrepareFilter
 * @Description
 * @Author xuxiangnan
 * @Date 2021/4/10 11:11
 */
public abstract class AbstractPrepareFilter {
    private AbstractPrepareFilter nextPrepareFilter;

    public AbstractPrepareFilter(AbstractPrepareFilter nextPrepareFilter){
        this.nextPrepareFilter = nextPrepareFilter;
    }

    public void doFilter(PreparationList preparationList, Student student){
        prepare(preparationList);
        if(nextPrepareFilter == null){
            student.study();
        }else {
            nextPrepareFilter.doFilter(preparationList,student);
        }
    }
    public abstract void prepare(PreparationList preparationList);
}

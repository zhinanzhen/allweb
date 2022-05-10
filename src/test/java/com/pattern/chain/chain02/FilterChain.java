package com.pattern.chain.chain02;

import com.pattern.chain.PreparationList;
import com.pattern.chain.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FilterChain
 * @Description
 * @Author xuxiangnan
 * @Date 2021/4/10 11:36
 */
public class FilterChain implements SudentPrepareFilter{
    private List<SudentPrepareFilter> studyPrepareFilterList = new ArrayList<>();
    private Student student;
    private int pos = 0;

    public FilterChain(Student student){
        this.student = student;
    }

    public void addFilter(SudentPrepareFilter sudentPrepareFilter){
        studyPrepareFilterList.add(sudentPrepareFilter);
    }

    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        if(pos == studyPrepareFilterList.size()){
            student.study();
        }else{
            studyPrepareFilterList.get(pos++).doFilter(preparationList, filterChain);
        }
    }
}

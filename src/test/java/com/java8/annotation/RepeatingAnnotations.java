package com.java8.annotation;

import java.lang.annotation.*;

/**
 * @ClassName RepeatingAnnotations
 * @Description
 * @Author xuxiangnan
 * @Date 2019/4/19 15:26
 */
public class RepeatingAnnotations {
    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    public @interface Filters {
        Filter[] value();
    }

    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    @Repeatable( Filters.class )
    public @interface Filter {
        String value();
    }

    @Filter( "filter1" )
    @Filter( "filter2" )
    public interface Filterable {
    }

    public static void main(String[] args) {
        Filter[] annotation = Filterable.class.getAnnotationsByType(Filter.class);
    }

}

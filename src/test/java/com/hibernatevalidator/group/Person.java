package com.hibernatevalidator.group;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @ClassName Person
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/12/26 14:23
 */
@Setter
@Getter
public class Person {
    @NotNull
    private String name;

    public Person(String name) {
        this.name = name;
    }
}

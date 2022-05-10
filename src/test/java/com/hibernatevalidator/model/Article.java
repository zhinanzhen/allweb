package com.hibernatevalidator.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @ClassName Article
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/12/25 16:50
 */
@Setter
@Getter
public class Article {
    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private Author author;
    @Past
    private Date createTime;
    @Past
    private Date modifyTime;
}

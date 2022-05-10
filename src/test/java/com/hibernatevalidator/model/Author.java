package com.hibernatevalidator.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName Author
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/12/25 16:48
 */
@Setter
@Getter
public class Author {
    @NotNull
    @Size(min = 6, max = 15)
    @Pattern(regexp = "([a-zA-Z]+\\d*)+")
    private String username;
    @NotNull
    @Size(min = 6, max = 20)
    private String password;
    @NotNull
    private String nickname;
    @Email
    private String email;
    @Min(0)
    private int age;
    @Size(max = 500)
    private String address;
    @Past
    @NotNull
    private Date birthday;
    @Valid
    @NotNull
    private List<Article> articles = new ArrayList<>();
}

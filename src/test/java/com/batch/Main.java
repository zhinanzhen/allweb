package com.batch;

import org.springframework.boot.SpringApplication;

/**
 * @ClassName Main
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/5/21 17:19
 */
public class Main {
    public static void main(String [] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(
                BatchConfiguration.class, args)));
    }
}

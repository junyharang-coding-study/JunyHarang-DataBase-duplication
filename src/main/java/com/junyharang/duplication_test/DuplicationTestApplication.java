package com.junyharang.duplication_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class DuplicationTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DuplicationTestApplication.class, args);
    }

}

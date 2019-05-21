package com.unicom.salesmanagebehind;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.unicom.salesmanagebehind.dao")
public class SalesmanagebehindApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesmanagebehindApplication.class, args);
    }

}

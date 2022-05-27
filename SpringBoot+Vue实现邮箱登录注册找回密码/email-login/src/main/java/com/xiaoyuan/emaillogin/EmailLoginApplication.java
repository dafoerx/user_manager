package com.xiaoyuan.emaillogin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.xiaoyuan"})
@MapperScan("com.xiaoyuan.emaillogin.db.mapper")
public class EmailLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailLoginApplication.class, args);
    }

}

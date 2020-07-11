package com.playwi0.ssologin;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
@MapperScan("com.playwi0.ssologin.mapper")
public class SsoLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoLoginApplication.class, args);
    }

}

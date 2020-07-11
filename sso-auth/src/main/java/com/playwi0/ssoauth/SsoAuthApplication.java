package com.playwi0.ssoauth;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class SsoAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoAuthApplication.class, args);
    }

}

package com.palwyi0.ssoredis;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class SsoRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoRedisApplication.class, args);
    }

}

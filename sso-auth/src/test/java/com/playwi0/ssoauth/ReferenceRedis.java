package com.playwi0.ssoauth;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.playwi0.ssoapi.common.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Playwi0
 * @Data: 2020/7/11
 */
@SpringBootTest
@EnableDubbo
public class ReferenceRedis {

    @Reference
    RedisService redisService;

    @Test
    public void test(){
        System.out.println(redisService.get("k1"));
    }
}

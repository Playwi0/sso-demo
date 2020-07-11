package com.palwyi0.ssoredis;

import com.playwi0.ssoapi.common.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SsoRedisApplicationTests {

    @Autowired
    RedisService redisService;

    @Test
    void contextLoads() {
        System.out.println(redisService.get("k1"));

    }

}

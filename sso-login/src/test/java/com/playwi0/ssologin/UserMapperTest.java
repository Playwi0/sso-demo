package com.playwi0.ssologin;

import com.playwi0.ssoapi.entity.User;
import com.playwi0.ssoapi.login.UserService;
import com.playwi0.ssocommon.util.ResultT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Playwi0
 * @Data: 2020/7/11
 */

@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserService userService;

    @Test
    public void test(){

        ResultT<User> admin = userService.findUser("admin", "Abc123#");

        System.out.println(admin.getData());
    }
}

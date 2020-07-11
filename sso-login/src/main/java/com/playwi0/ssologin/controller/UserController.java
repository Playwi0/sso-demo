package com.playwi0.ssologin.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.playwi0.ssoapi.auth.AuthService;
import com.playwi0.ssoapi.common.RedisService;
import com.playwi0.ssoapi.entity.AuthUser;
import com.playwi0.ssoapi.entity.User;
import com.playwi0.ssoapi.login.UserService;
import com.playwi0.ssocommon.util.ResultT;
import com.playwi0.ssocommon.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: Playwi0
 * @Data: 2020/7/10
 */

@RestController
public class UserController implements Serializable {

    private static final long serialVersionUID = 3489953899185004440L;
    @Reference
    AuthService authService;

    @Autowired
    UserService userService;

    @Reference
    RedisService redisService;

    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request, HttpServletResponse response){

        String token = SessionUtil.getToken(request);

        ResultT<AuthUser> resultT = authService.authToken(token);

        if (resultT != null && resultT.getCode() == ResultT.SUCCESS_CODE){

            return ((AuthUser)resultT.getData()).toString();
        }

        ResultT<User> userResultT = userService.findUser(username, password);

        if (userResultT.getCode() != ResultT.SUCCESS_CODE) return userResultT.getMsg();

        AuthUser authUser = new AuthUser();
        authUser.setUser(userResultT.getData());
        authUser.setToken(UUID.randomUUID().toString());
        authUser.setFreshTime(System.currentTimeMillis());
        authUser.setExpireTime(AuthUser.LOGIN_EXPIRE_TIME);
        redisService.setex(authUser.getToken(), 60, authUser);

        SessionUtil.setToken(response, authUser.getToken());

        return userResultT.getMsg();
    }
}

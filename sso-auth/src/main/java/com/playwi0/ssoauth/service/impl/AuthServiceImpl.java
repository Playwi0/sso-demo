package com.playwi0.ssoauth.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.playwi0.ssoapi.auth.AuthService;
import com.playwi0.ssoapi.common.RedisService;
import com.playwi0.ssoapi.entity.AuthUser;
import com.playwi0.ssocommon.util.ResultT;
import com.playwi0.ssocommon.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Playwi0
 * @Data: 2020/7/10
 */
@Service
@Component
public class AuthServiceImpl implements AuthService {

    @Reference
    RedisService redisService;

    @Override
    public ResultT<AuthUser> authToken(String token) {

        if (token == null) return null;

        AuthUser authUser = (AuthUser) redisService.get(token);

        if (authUser == null) return null;

        // token 过期
//        if ((System.currentTimeMillis() - authUser.getFreshTime()) > authUser.getExpireTime()){
//
//            return null;
//        }

        authUser.setFreshTime(System.currentTimeMillis());

        ResultT<AuthUser> resultT = new ResultT<>(ResultT.SUCCESS_CODE, null, authUser);

        return resultT;
    }
}

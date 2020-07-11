package com.playwi0.ssologin.service.impl;

import com.playwi0.ssoapi.entity.User;
import com.playwi0.ssoapi.login.UserService;
import com.playwi0.ssocommon.util.ResultT;
import com.playwi0.ssologin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Playwi0
 * @Data: 2020/7/10
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ResultT<User> findUser(String username, String password) {

        User user = userMapper.selectUserByName(username, password);

        if (user == null){
            return new ResultT<User>(ResultT.ERROR_CODE, "login error");
        }

        return new ResultT<User>(ResultT.SUCCESS_CODE, "login success", user);
    }
}

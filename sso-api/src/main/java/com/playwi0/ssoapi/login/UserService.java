package com.playwi0.ssoapi.login;

import com.playwi0.ssoapi.entity.User;
import com.playwi0.ssocommon.util.ResultT;

/**
 * @Author: Playwi0
 * @Data: 2020/7/10
 */
public interface UserService {

    ResultT<User> findUser(String username, String password);
}

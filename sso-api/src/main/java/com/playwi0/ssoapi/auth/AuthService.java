package com.playwi0.ssoapi.auth;

import com.playwi0.ssoapi.entity.AuthUser;
import com.playwi0.ssocommon.util.ResultT;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Playwi0
 * @Data: 2020/7/10
 */
public interface AuthService {

    ResultT<AuthUser> authToken(String token);
}

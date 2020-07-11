package com.playwi0.ssocommon.util;

import com.playwi0.ssocommon.constant.Constant;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @Author: Playwi0
 * @Data: 2020/7/10
 */
public class SessionUtil {


    /**
     * 从 cookie 中获取 token
     * @param request
     * @return
     */
    public static String getToken(HttpServletRequest request){

        if (request == null) return null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                String name = cookie.getName();
                if (name.equals(Constant.TOKEN_ID)){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static void setToken(HttpServletResponse response, String token){

        if (response == null) return;

        Cookie cookie = new Cookie(Constant.TOKEN_ID, token);

        response.addCookie(cookie);
    }


}

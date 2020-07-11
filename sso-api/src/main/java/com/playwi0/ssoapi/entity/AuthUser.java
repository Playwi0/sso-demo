package com.playwi0.ssoapi.entity;

import java.io.Serializable;

/**
 * @Author: Playwi0
 * @Data: 2020/7/10
 */
public class AuthUser implements Serializable {

    private static final long serialVersionUID = -1258159546044068585L;
    public static final int LOGIN_EXPIRE_TIME = 2;
    private User user;

    private String token;

    private int expireTime;

    private long freshTime;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(int expireTime) {
        this.expireTime = expireTime;
    }

    public long getFreshTime() {
        return freshTime;
    }

    public void setFreshTime(long freshTime) {
        this.freshTime = freshTime;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "user=" + user +
                ", token='" + token + '\'' +
                ", expireTime=" + expireTime +
                ", freshTime=" + freshTime +
                '}';
    }
}

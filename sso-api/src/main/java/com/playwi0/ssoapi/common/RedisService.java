package com.playwi0.ssoapi.common;

/**
 * @Author: Playwi0
 * @Data: 2020/7/10
 */
public interface RedisService {

    Object get(String key);

    boolean set(String key, Object value);

    boolean setex(String key, long second, Object value);

}

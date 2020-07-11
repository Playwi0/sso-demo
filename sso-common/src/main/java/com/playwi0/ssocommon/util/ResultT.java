package com.playwi0.ssocommon.util;

import java.io.Serializable;

/**
 * @Author: Playwi0
 * @Data: 2020/7/10
 */
public class ResultT<T> implements Serializable {
    private static final long serialVersionUID = 1742857160693755677L;

    public final static int SUCCESS_CODE = 200;
    public final static int ERROR_CODE = 500;

    public final static ResultT SUCCESS = new ResultT(SUCCESS_CODE,null);
    public final static ResultT ERROR = new ResultT(ERROR_CODE,null);


    private int code;
    private String msg;
    private T data;

    public ResultT() {
    }

    public ResultT(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultT(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResultT(String msg){
        this.code = SUCCESS_CODE;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultT{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

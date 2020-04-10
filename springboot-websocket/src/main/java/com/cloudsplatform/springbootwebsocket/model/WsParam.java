package com.cloudsplatform.springbootwebsocket.model;

/**
 * 
 *@description: 
 *@author: WuDG
 *@time: 2020/4/10 0:20
 * 
 */
public class WsParam<T> {
    private String method;
    private T param;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }
}

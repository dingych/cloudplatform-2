package com.cloudsplatform.springbootwebsocket.model;

/**
 * 
 *@description: 
 *@author: WuDG
 *@time: 2020/4/10 0:20
 * 
 */
public class WsResponse<T> {
    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}

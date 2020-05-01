package com.cloudplatform.jdklearndemo.proxy_demo.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName:TargetInvoker
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/18 14:15
 * @Version: V1.0
 * @since: JDK 1.8
 **/
public class TargetInvoker implements InvocationHandler {

    private Object target;

    public TargetInvoker(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk 代理执行前");
        Object result = method.invoke(target,args);
        System.out.println("jdk 代理执行后");
        return result;
    }
}

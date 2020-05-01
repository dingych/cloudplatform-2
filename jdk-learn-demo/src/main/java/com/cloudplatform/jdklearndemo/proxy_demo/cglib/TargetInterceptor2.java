package com.cloudplatform.jdklearndemo.proxy_demo.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName:TargetInterceptor2
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/18 14:50
 * @Version: V1.0
 * @since: JDK 1.8
 **/
public class TargetInterceptor2 implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 调用前 TargetInterceptor2");
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("cglib 调用后 TargetInterceptor2");
        return result;
    }
}

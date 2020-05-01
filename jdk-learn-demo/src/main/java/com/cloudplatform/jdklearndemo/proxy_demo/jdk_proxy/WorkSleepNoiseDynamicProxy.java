package com.cloudplatform.jdklearndemo.proxy_demo.jdk_proxy;

import java.lang.reflect.Proxy;

/**
 * @ClassName:SleepNoiseProxy
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/18 14:18
 * @Version: V1.0
 * @since: JDK 1.8
 **/
public class WorkSleepNoiseDynamicProxy {

    public static Object getProxy(Object target) {
        Object proxy = Proxy.newProxyInstance(
                // 指定目标类的类加载
                target.getClass().getClassLoader(),
                // 代理需要实现的接口，可指定多个
                target.getClass().getInterfaces(),
                // 代理对象处理器
                new TargetInvoker(target)
                );
        return proxy;
    }
}

package com.cloudplatform.jdklearndemo.proxy_demo.cglib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @ClassName:CglibPoxy
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/18 14:37
 * @Version: V1.0
 * @since: JDK 1.8
 **/
public class CglibPoxyFilter {
    public static Object getProxy(Class<?> clazz){
        Enhancer enhancer = new Enhancer();
        // 设置类加载
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        enhancer.setCallbacks(new Callback[]{new TargetInterceptor(),new TargetInterceptor2()});
        // 设置方法拦截器
        enhancer.setCallbackFilter(new TargetCallbackFilter());
        // 创建代理类
        return enhancer.create();
    }
}

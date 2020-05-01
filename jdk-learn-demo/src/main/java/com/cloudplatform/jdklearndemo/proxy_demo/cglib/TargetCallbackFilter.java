package com.cloudplatform.jdklearndemo.proxy_demo.cglib;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @ClassName:TargetCallbackFilter
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/18 14:48
 * @Version: V1.0
 * @since: JDK 1.8
 **/
public class TargetCallbackFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        if("speak".equals(method.getName())){
            return 1;
        }
        return 0;
    }
}

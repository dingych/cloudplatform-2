package com.cloudplatform.jdklearndemo.proxy_demo;

import com.cloudplatform.jdklearndemo.proxy_demo.cglib.CglibPoxy;
import com.cloudplatform.jdklearndemo.proxy_demo.cglib.CglibPoxyFilter;
import com.cloudplatform.jdklearndemo.proxy_demo.jdk_proxy.WorkSleepNoiseDynamicProxy;
import com.cloudplatform.jdklearndemo.proxy_demo.static_proxy.WorkerSleepNoiseStaticProxy;

/**
 * @ClassName:MianTest
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/18 14:06
 * @Version: V1.0
 * @since: JDK 1.8
 **/
public class MainTest {
    public static void main(String[] args) {
        staticProxy();
        jdkProxy();
        cglibProxy();
        cglibProxyFilter();
    }
    public static void staticProxy(){
        System.out.println("===========静态代理开始===========");
        SleepNoise sleep = new WorkerSleepNoise();
        sleep.display();
        new WorkerSleepNoiseStaticProxy(sleep).display();
    }


    /**
     *静态测试方法
     */
    public static void jdkProxy(){
        System.out.println("===========jdk动态代理开始===========");
        SleepNoise sleep = new WorkerSleepNoise();
        sleep.display();

        SleepNoise sleep1 = (SleepNoise)WorkSleepNoiseDynamicProxy.getProxy(sleep);
        sleep1.display();
    }
    /**
     *静态测试方法
     */
    public static void cglibProxy(){
        System.out.println("===========cglib动态代理开始===========");
        SleepNoise sleep = (SleepNoise)CglibPoxy.getProxy(WorkerSleepNoise.class);
        sleep.display();
    }
    /**
     *静态测试方法
     */
    public static void cglibProxyFilter(){
        System.out.println("===========cglib 过滤动态代理开始===========");
        SleepNoise sleep = (SleepNoise) CglibPoxyFilter.getProxy(WorkerSleepNoise.class);
        sleep.display();
        sleep.speak();

    }


}

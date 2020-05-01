package com.cloudplatform.jdklearndemo.proxy_demo.static_proxy;

import com.cloudplatform.jdklearndemo.proxy_demo.SleepNoise;

/**
 * @ClassName:WorkerSleepNoiseProxy
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/18 14:04
 * @Version: V1.0
 * @since: JDK 1.8
 **/
public class WorkerSleepNoiseStaticProxy implements SleepNoise {
    private SleepNoise proxy;

    public WorkerSleepNoiseStaticProxy(SleepNoise proxy) {
        this.proxy = proxy;
    }

    @Override
    public void display() {
        System.out.println("工人打呼----代理");
        proxy.display();
    }

    @Override
    public void speak() {

    }
}

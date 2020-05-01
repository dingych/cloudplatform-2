package com.cloudplatform.jdklearndemo.proxy_demo;

import com.cloudplatform.jdklearndemo.proxy_demo.SleepNoise;

/**
 * @ClassName:WorkerSleepNoise
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/18 14:03
 * @Version: V1.0
 * @since: JDK 1.8
 **/
public class WorkerSleepNoise implements SleepNoise {
    @Override
    public void display() {
        System.out.println("工人打呼");
    }
    @Override
    public void speak(){
        System.out.println("工人 speak");
    }
}

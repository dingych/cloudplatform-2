package com.cloudplatform.jdklearndemo.jvm.stack;

import com.cloudplatform.jdklearndemo.proxy_demo.static_proxy.People;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:Main
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/19 14:04
 * @Version: V1.0
 * @since: JDK 1.8
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {
//        List<People> all = new ArrayList<>();
//        while(true){
//            all.add(new People());
//            Thread.sleep(10);
//        }
        test1();
    }
    /**
     *静态测试方法
     */
    public int test(int a,int b){
        int c;
        c = a+ b;
        return c;
    }
    public static void test1() {
        String name = "沉默王二";
        // \u000dname="沉默王三";
        // \u000d
        // \u000dint a=3;
        // \u000dSystem.out.println(a);
        System.out.println(name);
    }
}
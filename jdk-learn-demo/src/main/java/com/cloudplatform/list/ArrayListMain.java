package com.cloudplatform.list;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @ClassName:ArrayListMain
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/23 15:35
 * @Version: V1.0
 * @since: JDK 1.8
 **/
public class ArrayListMain {
    private static ExecutorService fixedThreadPool = newFixedThreadPool(4);
    public static void main(String[] args) throws InterruptedException {
//        for (int i = 1; i <= 10; i++) {
//            MyThread myThread = new MyThread(i+"线程");
//            fixedThreadPool.execute(myThread);
//            myThread.join();
//            System.out.println("当前线程名:"+myThread.getName());
//        }
        float f1 = 3.4f;
        float f2 = 3.4f;
        System.out.println(f1 == f2);
    }
}

class MyThread extends Thread{
    static List<Integer> list = new ArrayList<>();
    Random dom = new Random();
    private String threadName;

    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while (list.size()<1000){
            list.add(dom.nextInt(5000));
            System.out.println(threadName+",集合size="+list.size());
        }
    }
}

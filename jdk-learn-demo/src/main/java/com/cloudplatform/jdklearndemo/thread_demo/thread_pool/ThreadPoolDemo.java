package com.cloudplatform.jdklearndemo.thread_demo.thread_pool;

import java.util.*;
import java.util.concurrent.*;

/**
 * @ClassName:ThreadPoolDemo
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/18 15:29
 * @Version: V1.0
 * @since: JDK 1.8
 **/
public class ThreadPoolDemo {
    private static Map<Integer, String> map = new ConcurrentHashMap<>();
    private static Random random = new Random();
    public static void main(String[] args) {
//        cachedThreadPool1();
        listNotSafe();
    }
    private static void cachedThreadPool1(){
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //每一次循环都会创建一个线程，因为在新的线程执行的时候，原有创建的线程都还没有结束
        for (int i = 0; i < 10; i++) {
            cachedThreadPool.execute(() -> {
                long threadId = Thread.currentThread().getId();
                System.out.println("线程ID:"+threadId);
                map.put(random.nextInt(1000),"index"+random.nextInt(5));
                System.out.println("map长度="+map.size());
            });
        }
    }
    public static void listNotSafe() {
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }).start();
        }
    }

}

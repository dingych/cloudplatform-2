package com.cloudplatform.jdklearndemo.thread_demo;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.Executors.*;

/**
 * @ClassName:BaseThreadMethodDemo
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/21 23:17
 * @Version: V1.0
 * @since: JDK 1.8
 **/
public class BaseThreadMethodDemo {

    private static ExecutorService fixedThreadPool = newFixedThreadPool(4);
    /**
     *静态测试方法
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 1; i <= 10; i++) {
//            MyThread myThread = new MyThread();
//            cachedThreadPool.execute(myThread);
            MyCallable myCallable = new MyCallable();
            Future<Integer> result = fixedThreadPool.submit(myCallable);
            System.out.println(result.get());
        }
    }
    @Test
    public void test(){

    }
}
class MyThread implements Runnable{
    private static volatile int ticks = 100;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(ticks>0){
            synchronized (this){
                lock.lock();
                System.out.println("线程名称：" + Thread.currentThread().getName()+",当前票数:"+ticks--);
                lock.unlock();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class MyCallable implements Callable{
    private static volatile int ticks = 100;

    @Override
    public Object call() throws Exception {
        while(ticks>0){
            synchronized (this){
                System.out.println("线程名称：" + Thread.currentThread().getName()+",当前票数:"+ticks--);
            }
            Thread.sleep(1000);
//            try {
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        return ticks;
    }
}

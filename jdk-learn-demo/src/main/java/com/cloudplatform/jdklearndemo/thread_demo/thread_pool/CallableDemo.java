package com.cloudplatform.jdklearndemo.thread_demo.thread_pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName:CallableDemo
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/19 16:14
 * @Version: V1.0
 * @since: JDK 1.8
 **/
public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "WuDG";
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
         FutureTask task = new FutureTask(new CallableDemo());
         new Thread(task).start();
        System.out.println(task.get());
    }
}

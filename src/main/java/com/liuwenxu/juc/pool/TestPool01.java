package com.liuwenxu.juc.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: TestPool01
 * Author: liuwenxu
 * Date: 2020/7/24 3:05 下午
 * Description:
 */
public class TestPool01 {
    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        ExecutorService threadPool = Executors.newCachedThreadPool();
//        ExecutorService threadPool = Executors.newScheduledThreadPool(5);
//        ExecutorService threadPool = Executors.newSingleThreadScheduledExecutor();
//        ExecutorService threadPool = Executors.newWorkStealingPool();


        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + "-ok"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();//线程池使用完必须关闭
        }

    }
}

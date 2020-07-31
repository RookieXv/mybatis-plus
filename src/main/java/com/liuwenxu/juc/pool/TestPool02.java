package com.liuwenxu.juc.pool;

import java.util.concurrent.*;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: TestPool01
 * Author: liuwenxu
 * Date: 2020/7/24 3:05 下午
 * Description:
 */
public class TestPool02 {
    public static void main(String[] args) {
//        ThreadFactory factory = r -> new Thread(r,"lwx-test-pool");
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()

        );


        try {
            for (int i = 1; i <= 9; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "-ok");
                    try {
                        Thread.sleep(10);//放大问题的发生，mac执行太快，看不出效果
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();//线程池使用完必须关闭
        }

    }
}

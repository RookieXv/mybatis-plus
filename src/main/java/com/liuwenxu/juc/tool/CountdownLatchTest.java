package com.liuwenxu.juc.tool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: CountdownLatchTest
 * Author: liuwenxu
 * Date: 2020/7/15 4:09 下午
 * Description:
 */
public class CountdownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 1; i < 6; i++) {
            new Thread(() -> {
                countDownLatch.countDown();//减1
                System.out.println(Thread.currentThread().getName() + "号出去了");
            }, String.valueOf(i)).start();
        }


        try {
            countDownLatch.await();//等待清零后，继续执行下面
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("人全部走完了，可以关门");
    }
}

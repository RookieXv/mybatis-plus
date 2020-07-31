package com.liuwenxu.juc.tool;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: SemaPhoreTest
 * Author: liuwenxu
 * Date: 2020/7/15 4:46 下午
 * Description:
 */
public class SemaPhoreTest {
    public static void main(String[] args) {
        //线程数量：停车位，true按获取顺序释放，默认false
//        Semaphore semaphore = new Semaphore(3);
        Semaphore semaphore = new Semaphore(3,true);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();//获取许可证
                    System.out.println(Thread.currentThread().getName() + "获得了停车位");
                    TimeUnit.SECONDS.sleep(3);
                    semaphore.release();//释放许可证
                    System.out.println(Thread.currentThread().getName() + "离开了停车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}

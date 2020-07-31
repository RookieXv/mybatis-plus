package com.liuwenxu.juc.tool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: CyclicBarrierTest
 * Author: liuwenxu
 * Date: 2020/7/15 4:30 下午
 * Description: 减法计数器
 * 允许一组线程全部等待彼此达到共同屏障点的同步辅助。
 * 循环阻塞在涉及固定大小的线程方的程序中很有用，这些线程必须偶尔等待彼此。
 * 屏障被称为循环 ，因为它可以在等待的线程被释放之后重新使用。
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(
                7,
                () -> System.out.println("召唤神龙成功!")//召唤神龙线程
        );

        //七颗龙珠线程
        for (int i = 1; i < 8; i++) {
            final int temp = i;
            new Thread(() -> {
                System.out.println("集齐了第" + temp + "颗龙珠；");

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }


    }
}

package com.liuwenxu.juc;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: SynchronizedTest
 * Author: liuwenxu
 * Date: 2020/7/10 5:42 下午
 * Description: 多线程synchronized   买票案例
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        Tickets tickets = new Tickets();

        new Thread(() -> {for (int i = 0; i < 40; i++) tickets.sell();}, "A").start();
        new Thread(() -> {for (int i = 0; i < 40; i++) tickets.sell();}, "B").start();
        new Thread(() -> { for (int i = 0; i < 40; i++) tickets.sell();}, "C").start();
    }
}

class Tickets {
    private Integer num = 30;

    // 队列
    public synchronized void sell() {
        if (num > 0) {
            System.out.println("窗口" + Thread.currentThread().getName()
                    + "卖出第" + (num--) + "张票，还剩：" + num + "张");
        }
    }
}



package com.liuwenxu.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: LockTest
 * Author: liuwenxu
 * Date: 2020/7/10 5:42 下午
 * Description: 多线程lock   买票案例
 */
public class LockTest {
    public static void main(String[] args) {
        Tickets2 tickets = new Tickets2();

        new Thread(()->{ for (int i = 0; i < 40; i++) tickets.sell(); },"A").start();
        new Thread(()->{ for (int i = 0; i < 40; i++) tickets.sell(); },"B").start();
        new Thread(()->{ for (int i = 0; i < 40; i++) tickets.sell(); },"C").start();
    }
}

class Tickets2 {
    private Integer num = 30;
    // lock三部曲
    // Lock l = ...; l.lock(); try { // access the resource protected by this lock } finally { l.unlock(); }
    Lock l = new ReentrantLock();

    public void sell() {
        l.lock();
        try {
            if (num > 0) {
                System.out.println("窗口" + Thread.currentThread().getName() + "卖出第" + (31-(num--)) + "张票，还剩：" + num + "张");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            l.unlock();
        }
    }
}



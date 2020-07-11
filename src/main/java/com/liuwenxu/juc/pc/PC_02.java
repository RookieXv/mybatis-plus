package com.liuwenxu.juc.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: PC_02
 * Author: liuwenxu
 * Date: 2020/7/10 6:52 下午
 * Description: 传统生产者消费者案例  等待--业务--唤醒
 */
public class PC_02 {
    public static void main(String[] args) {
        TrafficLight2 trafficLight = new TrafficLight2();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    trafficLight.change2Green();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    trafficLight.change2Red();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    trafficLight.change2Yellow();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

    }

}

/**
 * 信号灯
 * 红绿两种状态
 * 一个改变颜色的方法
 */
class TrafficLight2 {
    private String color = "red";

    /**
     * lock版本的：await（）=wait（），signal（）=notify（）
     * Condition可以单独监视一个线程，实现精准通知唤醒
     */
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();


    public void change2Green() throws InterruptedException {
        lock.lock();

        try {
            while (color.equals("green")) {
                condition1.await();
            }
//        TimeUnit.SECONDS.sleep(1);
            color = "green";
            System.out.println(Thread.currentThread().getName() + "==>" + color);
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void change2Red() throws InterruptedException {
        lock.lock();

        try {
            while (color.equals("red")) {
                condition2.await();
            }
            color = "red";
            System.out.println(Thread.currentThread().getName() + "==>" + color);
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void change2Yellow() throws InterruptedException {
        lock.lock();

        try {
            while (color.equals("yellow")) {
                condition3.await();
            }
            color = "yellow";
            System.out.println(Thread.currentThread().getName() + "==>" + color);
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

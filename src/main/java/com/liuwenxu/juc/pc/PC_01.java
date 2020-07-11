package com.liuwenxu.juc.pc;

import java.util.concurrent.TimeUnit;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: PC_01
 * Author: liuwenxu
 * Date: 2020/7/10 6:52 下午
 * Description: 传统生产者消费者案例  等待--业务--唤醒
 */
public class PC_01 {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                try {
                    trafficLight.change2Green();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                try {
                    trafficLight.change2Red();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                try {
                    trafficLight.change2Red();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                try {
                    trafficLight.change2Green();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }

}

/**
 * 信号灯
 * 红绿两种状态
 * 一个改变颜色的方法
 */
class TrafficLight{
    private String color = "red";

    /**
     * 是，就等待
     *
     * 线程也可以唤醒，而不会被通知，中断或超时，即所谓的虚假唤醒 。 虽然这在实践中很少会发生，但应用程序必须通过测试应该使线程被唤醒的条件来防范，并且如果条件不满足则继续等待。 换句话说，等待应该总是出现在循环中，就像这样：
     *
     *   synchronized (obj) {
     *          while (<condition does not hold>)
     *              obj.wait(timeout);
     *          ... // Perform action appropriate to condition
     *      }
     *
     * 不是，就执行
     * 然后，唤醒
     */
    public synchronized void change2Green() throws InterruptedException {
        while (color.equals("green")) {
            this.wait();
        }
//        TimeUnit.SECONDS.sleep(1);
        color = "green";
        System.out.println(Thread.currentThread().getName()+"==>"+color);
        this.notifyAll();
    }

    public synchronized void change2Red() throws InterruptedException {
        while (color.equals("red")) {
            this.wait();
        }
        color = "red";
        System.out.println(Thread.currentThread().getName()+"==>"+color);
        this.notifyAll();
    }


}

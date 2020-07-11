package com.liuwenxu.juc.pc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: People1
 * Author: liuwenxu
 * Date: 2020/7/11 10:12 下午
 * Description: 八锁问题2
 */
public class People2 {

    /**
     * synchronized锁的是方法的调用者，在这里就是people
     * static 修饰的方法属于Class，模版，只有一个
     */
    public static synchronized void eat() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("static synchronized method-> 吃饭");
    }

    public static synchronized void play() {
        System.out.println("static synchronized method-> 玩耍");
    }

    public synchronized void study() {
        System.out.println("synchronized method-> 学习");
    }
}

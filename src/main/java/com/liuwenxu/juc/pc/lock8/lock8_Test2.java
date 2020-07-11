package com.liuwenxu.juc.pc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: lock8_Test2
 * Author: liuwenxu
 * Date: 2020/7/11 10:01 下午
 * Description: 八锁问题测试类2
 */
public class lock8_Test2 {
    public static void main(String[] args) throws InterruptedException {

        /**
         * 问题5：同一对象调用两个静态同步方法，先执行哪个？
         * static synchronized method-> 吃饭
         * static synchronized method-> 玩耍
         *
         * 问题6：不同对象调用两个静态同步方法，先执行哪个？
         * static synchronized method-> 吃饭
         * static synchronized method-> 玩耍
         *
         * 问题7：同一对象调用1个静态同步方法,1个同步方法，先执行哪个？
         * synchronized method-> 学习
         * static synchronized method-> 吃饭
         *
         * 问题8：不同对象调用1个静态同步方法,1个同步方法，先执行哪个？
         * synchronized method-> 学习
         * static synchronized method-> 吃饭
         */
        People2 people = new People2();
        People2 people2 = new People2();
        new Thread(() -> people.eat(),"A").start();
        TimeUnit.SECONDS.sleep(2);
//        new Thread(() -> people2.play(),"B").start();
        new Thread(() -> people2.study(),"C").start();


    }
}

package com.liuwenxu.juc.pc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: lock8_Test1
 * Author: liuwenxu
 * Date: 2020/7/11 10:01 下午
 * Description: 八锁问题测试类
 */
public class lock8_Test1 {
    public static void main(String[] args) throws InterruptedException {

        /**
         * 问题1：同一对象调用两个同步方法，先执行哪个？
         * synchronized method -> 吃饭
         * synchronized method -> 玩耍
         *
         * 问题2：eat延迟4秒呢？
         * synchronized method -> 吃饭
         * synchronized method -> 玩耍
         *
         * 问题3：同一对象调用1个同步方法,1个普通方法，先执行哪个？不同对象呢？
         * General method -> 学习
         * synchronized method -> 吃饭
         *
         * General method -> 学习
         * synchronized method -> 吃饭
         *
         * 问题4：不同对象调用两个同步方法，先执行哪个？
         * synchronized method -> 玩耍
         * synchronized method -> 吃饭
         */
        //两个对象，两把锁
        People1 people = new People1();
        People1 people2 = new People1();

        new Thread(people::eat,"A").start();
        TimeUnit.SECONDS.sleep(2);
        new Thread(people2::play,"B").start();
        new Thread(people2::study,"C").start();


    }
}

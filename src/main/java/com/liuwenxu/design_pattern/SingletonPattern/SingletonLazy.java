package com.liuwenxu.design_pattern.SingletonPattern;

/**
 * Copyright (C), 2015-2021, https://www.liuwenxu.com/
 * FileName: Singleton
 * Author: liuwenxu
 * Date: 2021/2/28 6:31 下午
 * Description: 单例模式
 */
public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {}

    /**
     * 懒汉式：单线程，lazy loding
     */
    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    /**
     * 懒汉式：多线程，效率低
     * @return
     */
    public static synchronized SingletonLazy getInstance1() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    /**
     * （推荐）懒汉式：双重校验锁（DCL）多线程，效率高
     * @return
     */
    public static synchronized SingletonLazy getInstance2() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}


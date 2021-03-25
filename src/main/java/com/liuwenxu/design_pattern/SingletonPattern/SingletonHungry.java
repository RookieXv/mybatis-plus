package com.liuwenxu.design_pattern.SingletonPattern;

/**
 * Copyright (C), 2015-2021, https://www.liuwenxu.com/
 * FileName: Singleton
 * Author: liuwenxu
 * Date: 2021/2/28 7:08 下午
 * Description: 单例饿汉式
 */
public class SingletonHungry {
    private static SingletonHungry instance = new SingletonHungry();

    private SingletonHungry(){};

    public static SingletonHungry getInstance() {
        return instance;
    }

}

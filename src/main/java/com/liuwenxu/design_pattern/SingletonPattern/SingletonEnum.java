package com.liuwenxu.design_pattern.SingletonPattern;

/**
 * Copyright (C), 2015-2021, https://www.liuwenxu.com/
 * FileName: Singleton
 * Author: liuwenxu
 * Date: 2021/2/28 7:11 下午
 * Description: 单例枚举
 *
 * 枚举默认线程安全，防止反序列化和反射
 */
public enum SingletonEnum {
    INSTANCE;
    private SingletonEnum(){};

    public void test() {
        System.out.println("test----");
    }
}

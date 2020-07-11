package com.liuwenxu.juc;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: Demo0
 * Author: liuwenxu
 * Date: 2020/7/10 5:23 下午
 * Description:
 */
public class Demo0 {
    public static void main(String[] args) {

        new Thread().start();

        // 获取cpu的核数
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}


package com.liuwenxu.juc.collections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: ConcurrentHashMapTest
 * Author: liuwenxu
 * Date: 2020/7/30 4:31 下午
 * Description:
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        Map<Integer, Long> map = new ConcurrentHashMap<>();

        for (int i = 0; i < 20; i++) {
            final int temp = i;
            new Thread(()->{
                map.put(temp,System.currentTimeMillis());
                System.out.println(map);
            }).start();
        }
    }
}

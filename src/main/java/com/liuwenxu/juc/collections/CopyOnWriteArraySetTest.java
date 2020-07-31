package com.liuwenxu.juc.collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: CopyOnWriteArrayListTest
 * Author: liuwenxu
 * Date: 2020/7/29 2:25 下午
 * Description: 线程安全list
 */
public class CopyOnWriteArraySetTest {
    public static void main(String[] args) {
        Set<Long> set = new HashSet<>();
        Set<Long> synchronizedSet = Collections.synchronizedSet(set);

        CopyOnWriteArraySet<Long> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

        // 并发修改异常：Exception in thread "线程0" java.util.ConcurrentModificationException

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                copyOnWriteArraySet.add(System.currentTimeMillis());
                System.out.println(copyOnWriteArraySet);
            }, "线程" + i).start();
        }
    }
}

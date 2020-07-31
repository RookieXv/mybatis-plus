package com.liuwenxu.juc.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: CopyOnWriteArrayListTest
 * Author: liuwenxu
 * Date: 2020/7/29 2:25 下午
 * Description: 线程安全list
 */
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {
//        List<Long> list = new ArrayList<>();
//        List<Long> list = new Vector<>();
//        List<Long> list = new ArrayList<>();
//        List<Long> synchronizedList = Collections.synchronizedList(list);
        List<Long> list = new CopyOnWriteArrayList<>();

        // 并发修改异常：Exception in thread "线程0" java.util.Concurren1tModificationException
        /*
          new ArrayList<>(); JDK 1.2
          解决方案：
          1、new Vector<>(); JDK 1.0
          2、Collections.synchronizedList(list);
          3、new CopyOnWriteArrayList<>();JDK 1.5
         */
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(System.currentTimeMillis());
                System.out.println(list);
            }, "线程" + i).start();
        }
    }
}

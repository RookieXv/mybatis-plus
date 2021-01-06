package com.liuwenxu.juc.readwritelock;

import sun.management.counter.perf.PerfInstrumentation;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: Test
 * Author: liuwenxu
 * Date: 2020/7/31 4:13 下午
 * Description:
 */
public class Test {
    public static void main(String[] args) {
        CustomCache cache = new CustomCache();
//        CustomLockCache cache = new CustomLockCache();

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(()->{
                cache.put(temp,System.currentTimeMillis());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(()->{
                cache.get(temp);
            },String.valueOf(i)).start();
        }
    }
}

class CustomLockCache {
    private volatile Map<Integer, Long> map = new HashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(Integer k, Long v) {
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始存：" + k);
            map.put(k, v);
            Thread.sleep(10);
            System.out.println(Thread.currentThread().getName() + "存好了：" + k);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public void get(Integer k) {
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始取：" + k);
            Long v = map.get(k);
            Thread.sleep(10);
            System.out.println(Thread.currentThread().getName() + "取好了：" + v);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }
}

// 自定义缓存
class CustomCache {
    private volatile Map<Integer, Long> map = new HashMap<>();

    public void put(Integer k, Long v) {
        System.out.println(Thread.currentThread().getName() + "开始存：" + k);
        map.put(k, v);
        System.out.println(Thread.currentThread().getName() + "存好了：" + k);
    }

    public void get(Integer k) {
        System.out.println(Thread.currentThread().getName() + "开始取：" + k);
        Long v = map.get(k);
        System.out.println(Thread.currentThread().getName() + "取好了：" + v);
    }
}

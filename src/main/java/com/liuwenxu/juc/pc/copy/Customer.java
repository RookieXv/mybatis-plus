package com.liuwenxu.juc.pc.copy;

import java.util.List;

/**
 * @author Smith 2019/3/21
 */
public class Customer implements Runnable {

    List<Integer> cache;

    public Customer(List<Integer> cache) {
        this.cache = cache;
    }

    private void custom() {
        synchronized (cache) {
            while (cache.size() == 0) {
                try {
                    cache.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            cache.remove(0);
            System.out.println(Thread.currentThread().getName() + "消费者消费了一条。");
            cache.notifyAll();
        }
    }
    @Override
    public void run() {
        //会死锁
//        for (int i = 0; i < 20; i++) {
//            custom();
//        }
        while (true) {
            custom();
        }
    }
}


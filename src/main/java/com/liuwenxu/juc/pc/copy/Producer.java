package com.liuwenxu.juc.pc.copy;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Smith 2019/3/21
 */
public class Producer implements Runnable{

    List<Integer> cache;

    public void put() throws InterruptedException {
        synchronized (cache) {
            while (cache.size() == 1) {
                try {
                    cache.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            TimeUnit.SECONDS.sleep(1);

            cache.add(1);
            System.out.println(Thread.currentThread().getName() + "生产者生产了一条。");
            cache.notifyAll();
        }
    }

    public Producer(List<Integer> cache) {
        this.cache = cache;
    }

    @Override
    public void run() {
        while (true) {
            try {
                put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

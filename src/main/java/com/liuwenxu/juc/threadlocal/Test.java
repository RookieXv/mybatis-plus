package com.liuwenxu.juc.threadlocal;

/**
 * Copyright (C), 2015-2021, https://www.liuwenxu.com/
 * FileName: Test
 * Author: liuwenxu
 * Date: 2021/3/1 5:43 下午
 * Description:
 */
public class Test {
    public static void main(String[] args) {

        ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": " + integerThreadLocal.get());
            integerThreadLocal.set(10);
            System.out.println(Thread.currentThread().getName() + ": " + integerThreadLocal.get());
        }, "A").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": " + integerThreadLocal.get());
            integerThreadLocal.set(20);
            System.out.println(Thread.currentThread().getName() + ": " + integerThreadLocal.get());
        }, "B").start();

        /*
         * ThreadLocalMap 中使用的 key 为 ThreadLocal 的弱引用,而 value 是强引用。
         * 所以，如果 ThreadLocal 没有被外部强引用的情况下，在垃圾回收的时候，key 会被清理掉，
         * 而 value 不会被清理掉。这样一来，ThreadLocalMap 中就会出现 key 为 null 的 Entry。
         * 假如我们不做任何措施的话，value 永远无法被 GC 回收，这个时候就可能会产生内存泄露。
         * ThreadLocalMap 实现中已经考虑了这种情况，在调用 set()、get()、remove() 方法的时候，
         * 会清理掉 key 为 null 的记录。使用完 ThreadLocal方法后 最好手动调用remove()方法
         */
        integerThreadLocal.remove();
    }
}

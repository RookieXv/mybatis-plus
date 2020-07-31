package com.liuwenxu.juc.callable;

import java.util.Calendar;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: CallableTest
 * Author: liuwenxu
 * Date: 2020/7/15 3:49 下午
 * Description:
 */
public class CallableTest {
    public static void main(String[] args) {

        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);

        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();// 有缓存,结果会被缓存，只有一条打印
        try {
            String str = futureTask.get();// get可能会有阻塞，一般放在最后一行或者异步处理
            System.out.println(str);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }
}

class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName() + ": callable test";
    }
}

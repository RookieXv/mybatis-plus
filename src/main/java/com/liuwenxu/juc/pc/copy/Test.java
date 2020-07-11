package com.liuwenxu.juc.pc.copy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Smith 2019/3/21
 */
public class Test {

    public static void main(String[] args) {

        List<Integer> cache = new ArrayList<>();
        new Thread(new Producer(cache), "P1").start();
        new Thread(new Customer(cache), "C1").start();
        new Thread(new Customer(cache), "C2").start();
    }
}


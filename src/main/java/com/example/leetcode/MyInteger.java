package com.example.leetcode;

import static java.lang.Integer.parseInt;

/**
 * Copyright (C), 2016-2020, Mobius-Vision
 * FileName: MyInteger
 * Author: liuwenxu
 * Date: 2020/3/28 23:04
 * Description:
 */
public class MyInteger {
    private int value;

    public MyInteger(int value) {
        this.value = value;
    }

    private static class IntegerCache {
        static final int low = -128;
        static final int high;
        static final MyInteger cache[];

        static {
            System.out.println("static...");
            // high value may be configured by property
            int h = 127;
            String integerCacheHighPropValue =
                    sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
            if (integerCacheHighPropValue != null) {
                try {
                    int i = parseInt(integerCacheHighPropValue);
                    i = Math.max(i, 127);
                    // Maximum array size is Integer.MAX_VALUE
                    h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
                } catch( NumberFormatException nfe) {
                    // If the property cannot be parsed into an int, ignore it.
                }
            }
            high = h;

            cache = new MyInteger[(high - low) + 1];
            int j = low;
            for(int k = 0; k < cache.length; k++)
                cache[k] = new MyInteger(j++);

            // range [-128, 127] must be interned (JLS7 5.1.7)
            assert MyInteger.IntegerCache.high >= 127;
        }

        private IntegerCache() {}
    }

    public static MyInteger valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new MyInteger(i);
    }

    public static void main(String[] args) {


        MyInteger a = MyInteger.valueOf(100);
        MyInteger b = MyInteger.valueOf(100);
        MyInteger c = MyInteger.valueOf(200);
        MyInteger d = MyInteger.valueOf(200);

        System.out.println(a == b);
        System.out.println(c == d);

    }

}

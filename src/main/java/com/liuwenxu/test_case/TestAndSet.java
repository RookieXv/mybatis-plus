package com.liuwenxu.test_case;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: TestAndSet
 * Author: liuwenxu
 * Date: 2020/8/4 10:51 上午
 * Description:
 */
public class TestAndSet {
    public static void main(String[] args) {
        System.out.println(testAndSet(2,3));
    }

    public static int testAndSet(int oldstr, int newstr) {
        int old = oldstr;
        oldstr = newstr;
        return old;
    }
}

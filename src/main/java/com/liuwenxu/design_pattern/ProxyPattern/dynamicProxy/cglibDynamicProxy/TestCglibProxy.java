package com.liuwenxu.design_pattern.ProxyPattern.dynamicProxy.cglibDynamicProxy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Copyright (C), 2015-2021, https://www.liuwenxu.com/
 * FileName: TestCglibProxy
 * Author: liuwenxu
 * Date: 2021/2/28 9:09 下午
 * Description:
 */
public class TestCglibProxy {
    public static void main(String[] args) {
        AliSms proxy = (AliSms) AliSmsProxyFactory.getProxy(AliSms.class);
        proxy.sendMsg("hello cglib!");

        new ArrayList<>();
        new Vector<>();
        new LinkedList<>();
        new HashSet<>();
        new LinkedHashSet<>();
        new TreeSet<>();
        new HashMap<>();
        new Hashtable<>();
        new ConcurrentHashMap<>();

    }
}

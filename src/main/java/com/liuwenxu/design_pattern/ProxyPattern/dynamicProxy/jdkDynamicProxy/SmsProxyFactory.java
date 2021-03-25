package com.liuwenxu.design_pattern.ProxyPattern.dynamicProxy.jdkDynamicProxy;

import java.lang.reflect.Proxy;

/**
 * Copyright (C), 2015-2021, https://www.liuwenxu.com/
 * FileName: SmsProxyFactory
 * Author: liuwenxu
 * Date: 2021/2/28 8:12 下午
 * Description: 代理对象工厂类
 */
public class SmsProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 类加载器，用于加载代理对象
                target.getClass().getInterfaces(), // 被代理类实现的一些接口
                new SmsProxy(target)); // 接口对象
    }
}

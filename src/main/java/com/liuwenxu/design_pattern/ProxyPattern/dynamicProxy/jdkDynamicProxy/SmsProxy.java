package com.liuwenxu.design_pattern.ProxyPattern.dynamicProxy.jdkDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Copyright (C), 2015-2021, https://www.liuwenxu.com/
 * FileName: SmsProxy
 * Author: liuwenxu
 * Date: 2021/2/28 8:08 下午
 * Description: 代理类
 */
public class SmsProxy implements InvocationHandler {
    private final Object target;

    public SmsProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用方法之前");
        Object result = method.invoke(target, args);
        System.out.println("调用方法之后");
        return result;
    }
}

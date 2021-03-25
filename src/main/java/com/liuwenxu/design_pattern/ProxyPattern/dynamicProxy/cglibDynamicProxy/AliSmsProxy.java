package com.liuwenxu.design_pattern.ProxyPattern.dynamicProxy.cglibDynamicProxy;

import org.apache.http.util.Args;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Copyright (C), 2015-2021, https://www.liuwenxu.com/
 * FileName: AliSmsProxy
 * Author: liuwenxu
 * Date: 2021/2/28 9:02 下午
 * Description:
 */
public class AliSmsProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用方法之前");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("调用方法之后");
        return result;
    }
}

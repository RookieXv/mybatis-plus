package com.liuwenxu.design_pattern.ProxyPattern.dynamicProxy.cglibDynamicProxy;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Copyright (C), 2015-2021, https://www.liuwenxu.com/
 * FileName: AliSmsProxyFactory
 * Author: liuwenxu
 * Date: 2021/2/28 9:04 下午
 * Description:
 */
public class AliSmsProxyFactory {
    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new AliSmsProxy());
        // 创建代理类
        return enhancer.create();
    }
}

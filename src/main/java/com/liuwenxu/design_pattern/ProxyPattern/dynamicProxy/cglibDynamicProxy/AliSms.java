package com.liuwenxu.design_pattern.ProxyPattern.dynamicProxy.cglibDynamicProxy;

/**
 * Copyright (C), 2015-2021, https://www.liuwenxu.com/
 * FileName: AliSms
 * Author: liuwenxu
 * Date: 2021/2/28 9:00 下午
 * Description:
 */
public class AliSms {
    public String sendMsg(String msg) {
        System.out.println("发送消息: " + msg);
        return msg;
    }
}

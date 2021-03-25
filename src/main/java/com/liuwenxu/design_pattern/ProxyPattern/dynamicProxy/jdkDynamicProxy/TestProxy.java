package com.liuwenxu.design_pattern.ProxyPattern.dynamicProxy.jdkDynamicProxy;

/**
 * Copyright (C), 2015-2021, https://www.liuwenxu.com/
 * FileName: TestProxy
 * Author: liuwenxu
 * Date: 2021/2/28 8:15 下午
 * Description:
 */
public class TestProxy {
    public static void main(String[] args) {
        SmsService proxy = (SmsService) SmsProxyFactory.getProxy(new SmsServiceImpl());
        proxy.sendSms("hello proxy!");

        MailService proxy1 = (MailService) SmsProxyFactory.getProxy(new SmsServiceImpl());
        proxy1.sendMail("1212");
    }
}

package com.liuwenxu.design_pattern.ProxyPattern.dynamicProxy.jdkDynamicProxy;

/**
 * Copyright (C), 2015-2021, https://www.liuwenxu.com/
 * FileName: SmsServiceImpl
 * Author: liuwenxu
 * Date: 2021/2/28 8:06 下午
 * Description:
 */
public class SmsServiceImpl implements SmsService,MailService{
    @Override
    public String sendSms(String msg) {
        System.out.println("发送消息：" + msg);
        return msg;
    }

    @Override
    public String sendMail(String msg) {
        System.out.println("发送邮件：" + msg);
        return msg;
    }
}

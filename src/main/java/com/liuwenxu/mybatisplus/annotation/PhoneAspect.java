package com.liuwenxu.mybatisplus.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: PhoneAspect
 * Author: liuwenxu
 * Date: 2020/8/4 3:20 下午
 * Description:
 */
@Component
@Aspect
public class PhoneAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PhoneAspect.class);


    @Pointcut("@annotation(com.liuwenxu.mybatisplus.annotation.Phone)")
    public void phoneAspect() {
    }

    @Around("phoneAspect()")
    public void around(ProceedingJoinPoint point) {
        System.out.println("自定义注解");
        Object[] args = point.getArgs();
        Arrays.stream(args).forEach(System.out::println);
        LOGGER.info("args :"+ Arrays.toString(args));
        MethodSignature signature = (MethodSignature) point.getSignature();
        LOGGER.info("目标方法为："+signature.getDeclaringTypeName()+"."+signature.getName());
        Method method = signature.getMethod();
        Phone annotation = method.getAnnotation(Phone.class);
        LOGGER.info("目标注解："+annotation.toString());

    }
}

package com.liuwenxu.mybatisplus.annotation;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: Phone
 * Author: liuwenxu
 * Date: 2020/8/4 2:54 下午
 * Description: 判断字符串是否是手机号注解
 */
@Target({ElementType.METHOD,ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = PhoneAsp.class)
public @interface Phone {

    String message() default "手机号格式不正确";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

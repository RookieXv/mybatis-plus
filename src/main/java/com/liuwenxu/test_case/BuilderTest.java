package com.liuwenxu.test_case;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Objects;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: BuilderTest
 * Author: liuwenxu
 * Date: 2020/7/16 10:22 上午
 * Description: 构造器测试
 */
public class BuilderTest {
    public static void main(String[] args) {
//        User lwx = User.builder()
//                .age(18)
//                .name("lwx")
//                .build();
//        System.out.println(lwx);

        User.Builder builder = new User.Builder();
        builder.name("sdas").setAge(12);

        User user = builder.builder();
        System.out.println(user);
    }
}


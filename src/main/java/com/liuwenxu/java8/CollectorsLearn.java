package com.liuwenxu.java8;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Copyright (C), 2016-2020, Mobius-Vision
 * FileName: CollectorsLearn
 * Author: liuwenxu
 * Date: 2020/4/15 19:03
 * Description:
 */
public class CollectorsLearn {
    public static void main(String[] args) {
        ConcurrentMap<String, User> map = Stream.of(new User("zs1", 15), new User("zs2", 18),
                new User("zs3", 19), new User("zs4", 16))
                .parallel()
                .collect(Collectors.toConcurrentMap(User::getName, Function.identity()));

        map.forEach((k,v)->{
            System.out.println("key:value = " + k + " : " + v);
        });

        BeanUtils.copyProperties("","");
    }
}
class User{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

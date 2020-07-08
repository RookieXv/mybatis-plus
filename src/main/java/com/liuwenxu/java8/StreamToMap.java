package com.liuwenxu.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Copyright (C), 2016-2020, Mobius-Vision
 * FileName: StreamToMap
 * Author: liuwenxu
 * Date: 2020/4/15 0:47
 * Description: map(mapToInt,mapToLong,mapToDouble) 转换操作符，
 *              把比如A->B，这里默认提供了转int，long，double的操作符。
 */
public class StreamToMap {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add(1);
        list.add(2);
        list.add(3D);
        list.add(4D);
        list.add(5L);
        list.add(6L);
        list.add(null);

        list.stream()
                .filter(Objects::nonNull)
                .skip(1)
                .limit(3)
                .mapToInt(Object::hashCode)
                .forEach(System.out::println);

    }
}

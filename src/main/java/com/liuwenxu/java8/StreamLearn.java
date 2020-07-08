package com.liuwenxu.java8;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Copyright (C), 2016-2020, Mobius-Vision
 * FileName: Stream
 * Author: liuwenxu
 * Date: 2020/4/14 22:20
 * Description: java 8 stream
 * https://www.baeldung.com/java-8-streams
 */
public class StreamLearn {
    public static void main(String[] args) {
        // 创建一个空流
//        Stream<Object> emptyStream = Stream.empty();
//        System.out.println(emptyStream);

        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("s");
        list.add("d");
        list.add("f");
        list.add(null);
        list.stream()
                .filter(Objects::nonNull)
                .sorted()
                .forEach(System.out::println);
    }
}

package com.liuwenxu.java8;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Copyright (C), 2016-2020, Mobius-Vision
 * FileName: ReduceLearn
 * Author: liuwenxu
 * Date: 2020/4/16 15:14
 * Description:
 */
public class ReduceLearn {
    public static void main(String[] args) {
        String reduce = IntStream.of(1, 23, 344, 4)
                .mapToObj(String::valueOf)
                .reduce("+", String::concat);

        System.out.println(reduce);

        // 字符串连接 运算结果:str = "A-B-C-D"
        String str = Stream.of("A", "B", "C", "D").reduce((a, b) -> a + "-" + b).get();
        String str1 = Stream.of("A", "B", "C", "D").reduce(new StringBuilder(), (sb, s) -> sb.append(s).append("-"), StringBuilder::append).toString();
        String str2 = Stream.of("A", "B", "C", "D").collect(Collectors.joining("-"));
        String str3 = String.join("-", "A", "B", "C", "D");
        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        // 求最值 运算结果:minValue = -9.9 minValue2 = -12.1
        double minValue = Stream.of(-1.5, 1.0, -9.9, 2.0).reduce(Double.MAX_VALUE, Double::min);
        double minValue2 = Stream.of(-1.5, 1.0, -9.9, -2.0).reduce(-12.1, Double::min);
        System.out.println(minValue);
        System.out.println(minValue2);

        // 求和 运算结果: sum = 10 sum2 = 17
        int sum = Stream.of(1,2,3,4).reduce(Integer::sum).get();
        int sum2 = Stream.of(1,2,3,4).reduce(7, Integer::sum);
        System.out.println(sum);
        System.out.println(sum2);
    }
}

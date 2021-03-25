package com.liuwenxu.test_case;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import sun.java2d.pipe.SpanIterator;

import java.math.BigDecimal;
import java.util.*;

/**
 * Copyright (C), 2015-2021, https://www.liuwenxu.com/
 * FileName: Test1
 * Author: liuwenxu
 * Date: 2021/2/25 6:23 下午
 * Description:
 */
public class Test1 {

    @Test
    public void test1() {
        System.out.println(null==null);
    }

    @Test
    public void test2() {
        Byte a = 'a';
        Byte b = 'a';
        System.out.println(a==b);
    }

    @Test
    public void test3() {
        System.out.println(BigDecimal.ONE.add(BigDecimal.TEN));
    }

    @Test
    public void test4() {
        String[] myArray = {"Apple", "Banana", "Orange"};
        List<String> myList = Arrays.asList(myArray);
        //上面两个语句等价于下面一条语句
//        List<String> myList = Arrays.asList("Apple","Banana", "Orange");
        myList.add("a");// java.lang.UnsupportedOperationException
        System.out.println(myList.toString());

        List list = new ArrayList<>(Arrays.asList("a", "b", "c"));

    }

    /**
     * guava不可变集合
     */
    @Test
    public void test5() {
        String[] arr = {"Apple", "Banana", "Orange"};
        List<String> of = ImmutableList.of("string", "elements");
        List<String> copyOf = ImmutableList.copyOf(arr);

        of.add("a");
        copyOf.remove("Apple");
        System.out.println(of.size());
        System.out.println(copyOf.size());
    }

    /**
     * guava可变集合
     */
    @Test
    public void test6() {
        String[] arr = {"Apple", "Banana", "Orange"};
        List<String> of = Lists.newArrayList("string", "elements");
        List<String> copyOf = Lists.newArrayList(arr);

        of.add("a");
        copyOf.remove("Apple");
        System.out.println(of.size());
        System.out.println(copyOf.size());

        String [] s= new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list = Arrays.asList(s);
        Collections.reverse(list);
        s=list.toArray(new String[0]);//没有指定类型的话会报错

    }

    @Test
    public void test7() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
//        list.removeIf(e -> e.equals("1"));

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String e = it.next();
            if (e.equals("2")) {
                it.remove();
            }
        }

    }
}
